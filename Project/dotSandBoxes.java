import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

//窗体界面类
public class dotSandBoxes extends JFrame {
    startListener startl;
    ChessBoard chessboard;
    JButton start,undol;
    //构造方法
    dotSandBoxes() {
        setTitle("Dots and Boxes");
        setSize(720, 768);
        setLocation(200, 0);
        startl = new startListener();
        chessboard = new ChessBoard();
        start = new JButton("Start");
        undol = new JButton("Undo");
        add(undol, BorderLayout.NORTH);
        start.addActionListener(startl);
        add(start, BorderLayout.SOUTH);
        add(chessboard, BorderLayout.CENTER);
        chessboard.setBackground(Color.LIGHT_GRAY);

        undol.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                chessboard.undo();
            }
        });
    }

    class startListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            if (e.getSource() == start) {
                chessboard.setVisible(true);
                start.setEnabled(false);
            }
        }
    }
}

//棋盘界面及操作类
class ChessBoard extends JPanel {
    static int num;
    static String mode;
    static int length;
    static int chess[][] = new int[21][21];
    static int chessu[][] = new int[21][21];
    static int boxes[][] = new int[21][21];
    static int boxesu[][] = new int[21][21];
    static int player = 1;
    static int playeru;
    static JFrame f,frame;
    static JButton but1, but2, but3, but4, but5, but6, but7, butr;
    static int i = 1;
    boolean sb=true;
    Color qianlan=new Color(193,210,240);

    // 棋盘的构造方法
    public ChessBoard() {
        setVisible(false);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                boxes[i][j]=0;
                if (i % 2 == 0 && j % 2 == 0) {
                    chess[i][j] = 0;
                } else if (i % 2 == 1 && j % 2 == 0) {
                    chess[i][j] = 1;
                } else if (i % 2 == 0 && j % 2 == 1) {
                    chess[i][j] = 1;
                } else {
                    chess[i][j] = 0;
                }
            }
        }
        if (mode == "cvp") {
            player = 2;
            computerDo();
        }
        addMouseListener(new MouseAdapter() {
            int x;
            int y;
            public void mouseClicked(MouseEvent e) {
                x = e.getX();
                y = e.getY();
                coordinate dots = new coordinate(x, y);
                changeWord(dots.getX(), dots.getY());
                if (mode != "pvp") {
                    computerDo();
                }
            }
        });
    }

    public void computerDo() {
        int x;
        int y;
        if (!gameOver() && mode != "cvc") {
            while (player == 2) {
                comThink computerPlayer = new comThink(chess, boxes, length);
                x = computerPlayer.getX();
                y = computerPlayer.getY();
                changeWord(x, y);
            }
        }
        while (mode == "cvc" && (!gameOver())) {
            while (player == 1&& (!gameOver())) {
                comThink computerPlayer = new comThink(chess, boxes, length);
                x = computerPlayer.getX();
                y = computerPlayer.getY();
                if(x%2==1&&y%2==0) {
                    if(!(((y/2==0)&&(x-1)/2==0)&&((y/2==0)&&(x+1)/2==0))) {
                        JOptionPane.showMessageDialog(null, "player1 : ("+y/2+","+(x-1)/2+")---("+y/2+","+(x+1)/2+")", "information",
                                JOptionPane.INFORMATION_MESSAGE);
                        //  System.out.println("player1 : ("+(x-1)/2+","+y/2+")---("+(x+1)/2+","+y/2+")");
                    }
                } else {
                    if(!(((x/2==0)&&(y-1)/2==0)&&((x/2==0)&&(y+1)/2==0))) {
                        JOptionPane.showMessageDialog(null, "player1 : ("+(y-1)/2+","+x/2+")---("+(y+1)/2+","+x/2+")", "information",
                            JOptionPane.INFORMATION_MESSAGE);
                        //  System.out.println("player1 : ("+x/2+","+(y-1)/2+")---("+x/2+","+(y+1)/2+")");
                    }
                }
                changeWord(x, y);
            }
            while (player == 2&& (!gameOver())) {
                comThink computerPlayer = new comThink(chess, boxes, length);
                x = computerPlayer.getX();
                y = computerPlayer.getY();
                if(x%2==1&&y%2==0) {
                    if(!(((y/2==0)&&(x-1)/2==0)&&((y/2==0)&&(x+1)/2==0))) {
                    JOptionPane.showMessageDialog(null, "player2 : ("+y/2+","+(x-1)/2+")---("+y/2+","+(x+1)/2+")", "information",
                            JOptionPane.INFORMATION_MESSAGE);
                  //  System.out.println("player2 : ("+(x-1)/2+","+y/2+")---("+(x+1)/2+","+y/2+")");
                    }
                } else {
                    if(!(((x/2==0)&&(y-1)/2==0)&&((x/2==0)&&(y+1)/2==0))) {
                    JOptionPane.showMessageDialog(null, "player2 : ("+(y-1)/2+","+x/2+")---("+(y+1)/2+","+x/2+")", "information",
                            JOptionPane.INFORMATION_MESSAGE);
                  //  System.out.println("player2 : ("+x/2+","+(y-1)/2+")---("+x/2+","+(y+1)/2+")");
                    }
                }
                changeWord(x, y);
            }
        }
    }

    // 绘图方法
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    g.setColor(Color.BLACK);
                    g.fillOval(i * 40 + 10, j * 40 + 10, 10, 10);
                } else {
                    if (i % 2 == 0 && j % 2 == 1) {
                        if(boxes[i][j]==-1) {
                            g.setColor(Color.RED);
                        } else if(boxes[i][j]==-2){
                            g.setColor(Color.BLUE);
                        } else g.setColor(Color.BLACK);
                        if (chess[i][j] == -1) {
                            g.fillRoundRect(i * 40 + 10, j * 40 - 20, 5, 70, 10, 10);
                        } else {
                            g.drawRoundRect(i * 40 + 10, j * 40 - 20, 5, 70, 10, 10);// (i*40,j*40-20
                        }
                    } else if (i % 2 == 1 && j % 2 == 0) {
                        if(boxes[i][j]==-1) {
                            g.setColor(Color.RED);
                        } else if(boxes[i][j]==-2){
                            g.setColor(Color.BLUE);
                        } else g.setColor(Color.BLACK);
                        if (chess[i][j] == -1) {
                            g.fillRoundRect(i * 40 - 20, j * 40 + 10, 70, 5, 10, 10);
                        }
                        g.drawRoundRect(i * 40 - 20, j * 40 + 10, 70, 5, 10, 10);
                    } else { // 中间
                        if (boxes[i][j] == 1) {
                            g.setColor(Color.PINK);
                        } else {
                            g.setColor(qianlan);
                        }
                        if (chess[i][j] == 4) {
                            g.fillRoundRect(i * 40 - 25, j * 40 - 25, 75, 75,
                                    10, 10);
                        }
                    }
                }
            }
        }
    }

    // 更新画板方法
    public void update(Graphics g) {
        paint(g);
    }

    // 每走一步修改矩阵相应值
    public void changeWord(int x, int y) {
        int i = x;
        int j = y;
        chessu=chess;
        boxesu=boxes;
        playeru=player;
        if (chess[i][j] == 1) {
            if (i % 2 == 1 && j % 2 == 0) {
                chess[i][j] = -1;//表示已经走过了
                if(player==1){
                    boxes[i][j]=-1;
                }else if(player==2){
                    boxes[i][j]=-2;
                }
                if (j == 0) {
                    chess[i][j + 1]++;
                    boxes[i][j + 1] = player;// 保持方格属于最后一步执行的人
                    if (chess[i][j + 1] != 4) {
                        player = player % 2 + 1;// 行走权交还给另一个人
                    }
                } else if (j == length - 1) {
                    chess[i][j - 1]++;
                    boxes[i][j - 1] = player;
                    if (chess[i][j - 1] != 4) {
                        player = player % 2 + 1;
                    }
                } else {
                    chess[i][j + 1]++;
                    chess[i][j - 1]++;
                    boxes[i][j - 1] = player;// 保持方格属于最后一步执行的人
                    boxes[i][j + 1] = player;// 保持方格属于最后一步执行的人
                    if (chess[i][j + 1] != 4 && chess[i][j - 1] != 4) {
                        player = player % 2 + 1;
                    }
                }
            } else if (i % 2 == 0 && j % 2 == 1) {
                chess[i][j] = -1;//表示已经走过了
                if(player==1){
                    boxes[i][j]=-1;
                }else if(player==2){
                    boxes[i][j]=-2;
                }
                if (i == 0) {
                    chess[i + 1][j]++;
                    boxes[i + 1][j] = player;
                    if (chess[i + 1][j] != 4) {
                        player = player % 2 + 1;
                    }
                } else if (i == length - 1) {
                    chess[i - 1][j]++;
                    boxes[i - 1][j] = player;
                    if (chess[i - 1][j] != 4) {
                        player = player % 2 + 1;
                    }
                } else {
                    chess[i + 1][j]++;
                    chess[i - 1][j]++;
                    boxes[i - 1][j] = player;
                    boxes[i + 1][j] = player;
                    if (chess[i + 1][j] != 4 && chess[i - 1][j] != 4) {
                        player = player % 2 + 1;
                    }
                }
            }
        }
        repaint();
        gameOver();
        if (mode == "pvp") {
            JOptionPane.showMessageDialog(null, "It' s player" + player + "' s turn!", "hint",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // 判断是否结束游戏了
    public boolean gameOver() {
        int p1 = 0, p2 = 0;
        for (int m = 0; m < length; m++) {
            for (int n = 0; n < length; n++) {
                if (chess[m][n] == 4) {
                    if (boxes[m][n] == 1) {
                        p1++;
                    } else if (boxes[m][n] == 2) {
                        p2++;
                    }
                }
            }
        }
        if (p1 + p2 == num * num) {
            if(sb) {
                player = 1;
                if (p1 > p2) {
                    JOptionPane.showMessageDialog(null, "Player1 wins!  Score: " + p1 + " : " + p2, "information",
                            JOptionPane.INFORMATION_MESSAGE);
                } else if (p1 < p2) {
                    JOptionPane.showMessageDialog(null, "Player2 wins!  Score: " + p1 + " : " + p2, "information",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Game over, no winner.  Score: " + p1 + " : " + p2, "information",
                            JOptionPane.INFORMATION_MESSAGE);
                }

                File dest = new File("dest.txt");
                OutputStream os = null;
                InputStream is = null;
                try {
                    os = new FileOutputStream(dest, true);
                    String msg = "第" + i + "局" + ":   " + p1 + ":" + p2 + "\n";
                    i++;
                    byte[] datas = msg.getBytes();
                    os.write(datas, 0, datas.length);
                    os.flush();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (null != os) {
                            os.close();
                        }
                    } catch (Exception e) {}
                }
                try {
                    is = new FileInputStream(dest);

                    byte[] flush = new byte[1024];
                    int len ;
                    while ((len = is.read(flush)) != -1) {
                        String str = new String(flush, 0, len);
                        JOptionPane.showMessageDialog(null, str, "Score Board",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (
                        FileNotFoundException e) {
                    e.printStackTrace();
                } catch (
                        IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (null != is) {
                            is.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                sb=false;
                end();
            }
            return true;
        }
        return false;
    }

    public static void input() {
//            Scanner sc=new Scanner(System.in);
//            System.out.print("Input \"3*3\" or \"4*4\" or \"5*5\":");
//            String str=sc.next();
//            switch (str){
//                case "3*3":
//                    num=3;
//                    break;
//                case "4*4":
//                    num=4;
//                    break;
//                case "5*5":
//                    num=5;
//                    break;
//                default:
//            }
//            System.out.print("Input \"pvp\" or \"pvc\" or \"cvc\":");
//            String st=sc.next();
//            switch (st){
//                case "pvp":
//                    mode="pvp";
//                    break;
//                case "pvc":
//                    mode="pvc";
//                    break;
//                case "cvc":
//                    mode="cvc";
//                    break;
//            }
//            if(mode=="pvc"){
//                System.out.print("Who first? Input \"me\" or \"computer\":");
//                String judge=sc.next();
//                switch (judge){
//                    case "me":
//                        mode="pvc";
//                        break;
//                    case "computer":
//                        mode="cvp";
//                        break;
//                }
//            }
//            length=2*num+1;
        f = new JFrame("Choose");
        f.setBounds(400, 100, 320, 110);
        f.setLayout(new FlowLayout());
        but1 = new JButton("3*3");
        but2 = new JButton("4*4");
        but3 = new JButton("5*5");
        butr = new JButton("Random");
        f.add(but1);
        f.add(but2);
        f.add(but3);
        f.add(butr);
        chooseSize();
        f.setVisible(true);
    }

    public static void end(){
        frame = new JFrame("Play again?");
        frame.setBounds(600, 300, 350, 80);
        frame.setLayout(new FlowLayout());
        JButton yes = new JButton("Yes");
        JButton no = new JButton("No");
        frame.add(yes);
        frame.add(no);
        frame.setVisible(true);

        yes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                input();
            }
        });

        no.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                JOptionPane.showMessageDialog(null, "Produced by: Fu Yunfan & Hou Yuyang ", "End",
                        JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        });
        f.setVisible(false);
    }

    //选择棋盘大小
    private static void chooseSize() {

        but1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                num = 2;
                length = 2 * num + 1;
                chooseMode();
            }
        });

        but2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                num = 3;
                length = 2 * num + 1;
                chooseMode();
            }
        });

        but3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                num = 4;
                length = 2 * num + 1;
                chooseMode();
            }
        });

        butr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                num = 5+(int)(Math.random()*4);
                length = 2 * num + 1;
                chooseMode();
            }
        });
    }

    //选择对战模式
    public static void chooseMode() {
        but4 = new JButton("pvp");
        but5 = new JButton("pvc");
        but6 = new JButton("cvp");
        but7 = new JButton("cvc");

        f.add(but4);
        f.add(but5);
        f.add(but6);
        f.add(but7);
        f.setVisible(true);

        but4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                mode = "pvp";
                dotSandBoxes d = new dotSandBoxes();
                d.setVisible(true);
            }
        });

        but5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                mode = "pvc";
                dotSandBoxes d = new dotSandBoxes();
                d.setVisible(true);
            }
        });

        but6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                mode = "cvp";
                dotSandBoxes d = new dotSandBoxes();
                d.setVisible(true);
            }
        });

        but7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                mode = "cvc";
                dotSandBoxes d = new dotSandBoxes();
                d.setVisible(true);
            }
        });
    }

    public void undo(){
        chess=chessu;
        boxes=boxesu;
        player=playeru;
        JOptionPane.showMessageDialog(null, "undo", "information",
                JOptionPane.INFORMATION_MESSAGE);
        repaint();
        setVisible(true);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        input();
    }
}

//电脑智能下棋类
class comThink {
    private int x;
    private int y;
    private int[][] chessArray;
    int[][] BoxesArray;

    comThink(int[][] a, int[][] b, int length) {
        chessArray = a;
        BoxesArray = b;
        nextStep(length);
    }

    //获得X值
    public int getX() {
        return x;
    }

    //获得y值
    public int getY() {
        return y;
    }

    //沙雕法
    public void nextStep(int length) {
        boolean threeFlag;//判断有无自由度为1的
        threeFlag = false;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (chessArray[i][j] == 3) {
                    if (chessArray[i + 1][j] == 1) {
                        this.x = i + 1;
                        this.y = j;
                    } else if (chessArray[i - 1][j] == 1) {
                        this.x = i - 1;
                        this.y = j;
                    } else if (chessArray[i][j + 1] == 1) {
                        this.x = i;
                        this.y = j + 1;
                    } else {
                        this.x = i;
                        this.y = j - 1;
                    }
                    threeFlag = true;
                }
            }
        }
        int LeftLines = 0;
        int s = 0;
        int a = 0;
        if (!threeFlag) {
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    if (chessArray[i][j] == 1 && ((i % 2 == 1 && j % 2 == 0) || (i % 2 == 0 && j % 2 == 1))) {
                        LeftLines++;
                    }
                }
            }
            s = (int) (Math.random() * (LeftLines + 1));//随机选一个
            for (int i = 0; i < chessArray.length; i++) {
                for (int j = 0; j < chessArray[i].length; j++) {
                    if (chessArray[i][j] == 1 && ((i % 2 == 1 && j % 2 == 0) || (i % 2 == 0 && j % 2 == 1))) {
                        a++;
                        if (a == s) {
                            this.x = i;
                            this.y = j;
                            break;
                        }
                    }
                }
            }
        }
    }
}

//界面按钮与矩阵坐标对应类
class coordinate {
    private int x;
    private int y;
    coordinate(int x1, int y1) {                
        int x2 = 0;
        int y2 = 0;
        x2 = x1 / 40;
        y2 = y1 / 40;
        if (x1 % 40 == x1 % 80) {
            if (x2 * 40 + 20 < x1 && x1 < x2 * 40 + 40 && y2 * 40 < y1 && y1 < y2 * 40 + 20) {
                x = x2 + 1;
                y = y2;
            }
        } else {
            if (x2 * 40 < x1 && x1 < x2 * 40 + 40 && y2 * 40 < y1 && y1 < y2 * 40 + 20) {
                x = x2;
                y = y2;
            }
        }
        if (y1 % 40 == y1 % 80) {
            if (x2 * 40 < x1 && x1 < x2 * 40 + 20 && y2 * 40 + 20 < y1 && y1 < y2 * 40 + 40) {
                x = x2;
                y = y2 + 1;
            }
        } else {
            if (x2 * 40 < x1 && x1 < x2 * 40 + 20 && y2 * 40 < y1 && y1 < y2 * 40 + 40) {
                x = x2;
                y = y2;
            }
        }
    }
    public int getX() {    //获得x坐标
        return x;
    }
    public int getY() {    //获得y坐标
        return y;
    }
}

