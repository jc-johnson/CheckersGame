package CheckerBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by jordan on 5/7/16.
 */
public class Board  extends JComponent {

    // dimension of checkerboard square (25% bigger than checker)

    private final static int SQUAREDIM = (int) (Checker.getDimension() * 1.25);

    // dimension of checkeroard (width of 8 squares)

    private final int BOARDDIM = 8 * SQUAREDIM;

    // prefered size of Board component

    private Dimension dimPrefSize;

    // dragging flag -- set to true when user presses mouse button over checker
    // and cleared to false when user releases mouse button

    private boolean inDrag = false;

    // displacement between drag start coordinates and checker center coordinate

    private int deltax, deltay;

    // reference to positioned checker at start of drag

    private PosCheck posCheck;

    // center loccation of checker at start of drag

    private int oldcx, oldcy;

    // list of Checker objects and their initial positions

    private List posChecks;

    public Board(){

        posChecks = new Arraylist&lt;&gt();
        dimPrefSize = new Dimension(BOARDDIM, BOARDDIM);

        addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent me) {
                // Obtain mouse coordinates at time of press.
                int x = me.getX();
                int y = me.getY();

                // Locate positioned checker under mouse press.

                for (PosCheck posCheck: posChecks)
                    if (Checker.contains(x, y, posCheck.cx,
                            posCheck.cy)) {
                        Board.this.posCheck = posCheck;
                        oldcx = posCheck.cx;
                        olccy = posCheck.cy;
                        deltax = x - posCheck.cx;
                        deltay = y - posCheck.cy;
                        inDrag = true;
                        return;
                    }
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                // When mouse released, clear inDrag (to
                // indicate no drag in progress) if inDrag
                // is already set.

                if (inDrag)
                    inDrag = false;
                else
                    return;

                // Snap checker to center of square.

                int x = me.getX();
                int y = me.getY();
                posCheck.cx = (x - deltax) / SQUAREDIM * SQUAREDIM +
                        SQUAREDIM / 2;
                posCheck.cy = (y - deltay) / SQUAREDIM * SQUAREDIM +
                        SQUAREDIM / 2;

                // Do not move checker onto occupied square.

                for (PosCheck posCheck : posChecks) {
                    if (posCheck != Board.this.posCheck &amp;&amp)
                }
            }
        })
    }
}
