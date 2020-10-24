package lesson4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TicTacToeTest {

    @Before
    public void init() {
        TicTacToe.initMap(3);
    }

    @Test
    public void test1() {
        TicTacToe.moveUser(0, 0, 'X');
        TicTacToe.moveUser(1, 1, 'X');
        TicTacToe.moveUser(2, 2, 'X');
        Assert.assertTrue(TicTacToe.checkWin('X'));
    }
    @Test
    public void test2() {
        TicTacToe.moveUser(0, 0, 'X');
        TicTacToe.moveUser(1, 0, 'X');
        TicTacToe.moveUser(2, 0, 'X');
        Assert.assertTrue(TicTacToe.checkWin('X'));
    }
    @Test
    public void test3() {
        TicTacToe.moveUser(0, 0, 'X');
        TicTacToe.moveUser(1, 1, 'X');
        TicTacToe.moveUser(2, 2, 'X');
        Assert.assertTrue(TicTacToe.checkWin('X'));
    }
    @Test
    public void test4() {
        TicTacToe.moveUser(0, 0, 'X');
        TicTacToe.moveUser(0, 1, 'X');
        TicTacToe.moveUser(1, 1, 'X');
        Assert.assertFalse(TicTacToe.checkWin('X'));
    }

}
