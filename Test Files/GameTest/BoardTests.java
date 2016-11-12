package GameTest;
import com.company.TaronBot.Game.Board;
import com.company.TaronBot.Game.Move;
import com.company.TaronBot.Game.Moves.DeStack;
import com.company.TaronBot.Game.Moves.Placement;
import junit.framework.*;


import java.util.LinkedList;
import java.util.List;

/**
 * Created by sarnowskit on 11/1/2016.
 */
public class BoardTests extends TestCase{
    protected Board board;
    public void setUp(){
        board=null;
    }
    public void testCreate(){
        board =new Board(5,new LinkedList<>(),true);
        for (int i = 0; i <5 ; i++) {
            for (int j = 0; j <5 ; j++) {
                for (int k = 0; k <6 ; k++) {
                    assertTrue(board.getAIMap(true)[i][j][k]==0);

                }
            }
        }
    }
    public void testCreatePlace(){
        List<Move> moves=new LinkedList<>();
        moves.add(new Placement(0,0,1,0));
        moves.add(new Placement(0,1,1,0));
        board =new Board(5,moves,true);
        assertTrue(board.getAIMap(true)[0][0][0]==1);
        assertTrue(board.getAIMap(true)[0][1][0]==-1);


    }
    public void testPlacementVictory(){
        board =new Board(5,new LinkedList<>(),true);
        for (int i = 1; i <5 ; i++) {
            board.getMap()[0][i].add(1);

        }
        assertTrue(board.checkForVictory()!=null);
    }
    public void testPlacementFalseVictory(){
        board =new Board(5,new LinkedList<>(),true);
        for (int i = 1; i <5 ; i++) {
            board.getMap()[0][i].add(1);

        }
        board.getMap()[0][0].add(-1);
        assertTrue(board.checkForVictory()==null);

    }
    public void testMovementVictory(){
        board =new Board(5,new LinkedList<>(),true);
        for (int i = 1; i <5 ; i++) {
            board.getMap()[i][0].add(1);

        }
        board.getMap()[0][0].add(-1);
        board.getMap()[0][1].add(1);
        board.getMap()[1][1].add(-1);

        assertTrue(board.checkForVictory()!=null);

    }


}