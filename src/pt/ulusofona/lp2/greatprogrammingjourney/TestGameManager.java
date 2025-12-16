package pt.ulusofona.lp2.greatprogrammingjourney;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.ulusofona.lp2.greatprogrammingjourney.board.Board;
import pt.ulusofona.lp2.greatprogrammingjourney.board.Slot;
import pt.ulusofona.lp2.greatprogrammingjourney.player.Player;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class TestGameManager {
    GameManager gm;
    String[][] players;

    // initialize a new setup every time a test executes...
    @BeforeEach
    public void setUp() {
        gm = new GameManager();
        players = new String[][]{
                {"1", "Han Solo", "Java;Python", "Green"},
                {"2", "Darth Vader", "C++;JavaScript", "Purple"}
        };
    }

    // create initial board
    @Test
    public void testCreateInitialBoardValid() {
        assertTrue(gm.createInitialBoard(players, 10));
    }

    @Test
    public void testCreateInitialBoardTooFewPlayers() {
        String[][] p = {{"1", "Alice", "Java", "Green"}};
        assertFalse(gm.createInitialBoard(p, 10));
    }

    @Test
    public void testCreateInitialBoardTooManyPlayers() {
        String[][] p = {
                {"1","A","Java","Green"},
                {"2","B","C","Blue"},
                {"3","C","C++","Purple"},
                {"4","D","Python","Brown"},
                {"5","E","Java","Green"}
        };
        assertFalse(gm.createInitialBoard(p, 10));
    }

    @Test
    public void testCreateInitialBoardInvalidColor() {
        String[][] p = {{"1","Alice","Java","Pink"}, {"2","Bob","C++","Purple"}};
        assertFalse(gm.createInitialBoard(p, 10));
    }

    @Test
    public void testCreateInitialBoardWorldTooSmall() {
        assertFalse(gm.createInitialBoard(players, 3));
    }

    @Test
    public void testCreateInitialBoardWithModifiers() {
        String[][] mods = {{"1","4","33"}};
        assertFalse(gm.createInitialBoard(players, 10, mods));
        assertTrue(gm.createInitialBoard(players, 50, mods));
    }

    // move current player
    @Test
    public void testMoveCurrentPlayerValid() {
        gm.createInitialBoard(players, 10);
        assertTrue(gm.moveCurrentPlayer(3));
        String[] info = gm.getProgrammerInfo(1);
        assertEquals("4", info[4]);
    }

    @Test
    public void testMoveCurrentPlayerInvalidSpaces() {
        gm.createInitialBoard(players, 10);
        assertFalse(gm.moveCurrentPlayer(0));
        assertFalse(gm.moveCurrentPlayer(7));
    }

    @Test
    public void testMoveCurrentPlayerWithAssemblyRestriction() {
        String[][] p = {{"1","Alice","Assembly","Green"},{"2","Bob","C++","Purple"}};
        gm.createInitialBoard(p, 10);
        assertTrue(gm.moveCurrentPlayer(2));
        assertFalse(gm.moveCurrentPlayer(3)); // should be restricted
    }

    @Test
    public void testMoveCurrentPlayerWithCRestriction() {
        String[][] p = {{"1","Alice","C","Green"},{"2","Bob","C++","Purple"}};
        gm.createInitialBoard(p, 10);
        assertTrue(gm.moveCurrentPlayer(3));
        assertFalse(gm.moveCurrentPlayer(4)); // should be restricted
    }

    // get react to abyss and tools
    @Test
    public void testReactToAbyssOrToolNoModifier() {
        gm.createInitialBoard(players, 10);
        assertNull(gm.reactToAbyssOrTool());
    }

    // get current player id
    @Test
    public void testGetCurrentPlayerID() {
        gm.createInitialBoard(players, 10);
        assertEquals(1, gm.getCurrentPlayerID());
    }

    // game is over
    @Test
    public void testGameIsOverFalse() {
        gm.createInitialBoard(players, 10);
        assertFalse(gm.gameIsOver());
    }

    @Test
    public void testGameIsOverTrue() {
        gm.createInitialBoard(players, 4);
        gm.moveCurrentPlayer(4);
        assertTrue(gm.gameIsOver());
    }

    // valida players
    @Test
    public void testPlayerValidateValid() {
        HashMap<Integer, Player> map = new HashMap<>();
        assertTrue(Player.validate(new String[]{"1","Alice","Java","Green"}, map));
    }

    @Test
    public void testPlayerValidateInvalidId() {
        HashMap<Integer, Player> map = new HashMap<>();
        assertFalse(Player.validate(new String[]{"0","Alice","Java","Green"}, map));
    }

    @Test
    public void testPlayerValidateDuplicateId() {
        HashMap<Integer, Player> map = new HashMap<>();
        map.put(1, new Player(new String[]{"1","Alice","Java","Green"}));
        assertFalse(Player.validate(new String[]{"1","Bob","C","Purple"}, map));
    }

    @Test
    public void testPlayerValidateEmptyName() {
        HashMap<Integer, Player> map = new HashMap<>();
        assertFalse(Player.validate(new String[]{"1","","Java","Green"}, map));
    }

    @Test
    public void testPlayerValidateInvalidColor() {
        HashMap<Integer, Player> map = new HashMap<>();
        assertFalse(Player.validate(new String[]{"1","Alice","Java","Pink"}, map));
    }

    // board and slots stuff
    @Test
    public void testBoardInitialization() {
        Board board = new Board(5);
        assertEquals(5, board.size());
        for (int i = 1; i <= 5; i++) {
            assertNotNull(board.getSlot(i));
        }
    }

    @Test
    public void testBoardSlotImage() {
        Board board = new Board(5);
        assertNull(board.slotImage(3));
        assertEquals("glory.png", board.slotImage(5));
    }

    @Test
    public void testSlotModifier() {
        Slot slot = new Slot();
        assertFalse(slot.hasModifier());
        slot.setModifier(null);
        assertFalse(slot.hasModifier());
    }

    // save and loads stuff
    @Test
    public void testSaveAndLoadGame() throws FileNotFoundException, InvalidFileException {
        gm.createInitialBoard(players, 10);
        gm.moveCurrentPlayer(3);

        File file = new File("test_game_save.txt");
        assertTrue(gm.saveGame(file));

        GameManager gm2 = new GameManager();
        gm2.loadGame(file);
        assertEquals(1, gm2.getCurrentPlayerID());
        assertEquals(4, Integer.parseInt(gm2.getProgrammerInfo(1)[4]));

        file.delete();
    }
}
