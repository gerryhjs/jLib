package basic_Algorithm;

import dataStructure.BinarySearchTree;
import dataStructure.BinaryTreeNode;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MainForm extends JFrame {
	//private static boolean isAdmin;
	private int mode;
	private int DEFAULT_MAX_INT=32768;
	private static final long serialVersionUID = -2356225256605068092L;
	private JPanel contentPane;
	private static Map map;
	private static boolean load;
	private static int lab;
	private JLabel mainLabel;
	private JLabel resultLabel;
	private List list;
	int n;
	basic_Algorithm.SortArray SortArray;
	Object[] options ={"Original","Improve"}; 
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm frame = new MainForm();
					frame.setVisible(true);
					//DriverRNN();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	@SuppressWarnings("deprecation")
	public MainForm() throws IOException, FileNotFoundException {
		
		setResizable(false);
		setTitle("Algorithm Labs");
	

		
		//ioIn();
	
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(20, 20, 754, 553);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		final List list = new List();
		list.setMultipleSelections(false);
		final JLabel mainLabel = new JLabel();
		mainLabel.setFont(new Font("Serif", Font.BOLD, 15));
		final JButton btnSelect = new JButton("Select");
		final JButton btnMap1 = new JButton("Map1");
		final JLabel resultLabel = new JLabel();
		final JButton initData = new JButton("Reset*");
		final JButton btnAdd = new JButton("Add");
		final JRadioButton r1 = new JRadioButton("Random");
		final JRadioButton r2 = new JRadioButton("Order");
		final JRadioButton r3 = new JRadioButton("Disorder");
		final JRadioButton r4 = new JRadioButton("Same");
		
		
		r1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				r2.setSelected(false);
				r3.setSelected(false);
				r4.setSelected(false);
			}
		});
		
		r2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				r1.setSelected(false);
				r3.setSelected(false);
				r4.setSelected(false);
			}
		});
		r3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				r2.setSelected(false);
				r1.setSelected(false);
				r4.setSelected(false);
			}
		});
		r4.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				r2.setSelected(false);
				r3.setSelected(false);
				r1.setSelected(false);
			}
		});
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VertexNode vn=map.getVertex(list.getSelectedItem());
				if (vn!=null)
				{
					
				}
				EdgeNode en=map.getEdge(list.getSelectedItem());
				if (en!=null)
				{
					
				}
			}
		});
		final JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VertexNode vn=map.getVertex(list.getSelectedItem());
				if (vn!=null)
				{
					Object[] options ={"Confirm","Cancel"};   
				    int reply=JOptionPane.showOptionDialog(null, "Are you sure to remove "+vn.getName()+"?", "Question", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
				    if (reply==0)
				    {
				    	map.removeVertex(vn);
				    	for (EdgeNode Scanner:map.getEdgeNode())
				    	{
				    		if (Scanner.getFrom().equals(vn.getName())) map.removeEdge(Scanner);
				    		if (Scanner.getTo().equals(vn.getName())) map.removeEdge(Scanner);
				    	}
				    	Notice("Remove Vertex"+vn.getName());
				    	refresh();
				    }
				}
				EdgeNode en=map.getEdge(list.getSelectedItem());
				if (en!=null)
				{
					Object[] options ={"Confirm","Cancel"};   
				    int reply=JOptionPane.showOptionDialog(null, "Are you sure to remove "+en.getDetail()+"?", "Question", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
				    if (reply==0)
				    {
				    
				    }
				}
			}
		});
		final JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		final JButton btnDijkstra = new JButton("Dijkstra");
		btnDijkstra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainLabel.setText("");
				 Date start = new Date();
				map.init(map.getVertex("A"),map.getVertex("F"));
				long len=map.Dijkstra(map.getVertex("A"), map.getVertex("F"));
				 Date end = new Date();
					Notice(map.VertexArrayToPrint(map.route));	
				Result("Caculate by Dijkstra answer is:"+len+" Time use:"+(end.getTime()-start.getTime())+"ms");
			}
		});
		final JButton btnGoThrough = new JButton("Brute Force");
		btnGoThrough.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainLabel.setText("");
				map.init(map.getVertex("A"), map.getVertex("F"));
				 Date start = new Date();
				long len=map.BruteForce(map.getVertex("A"), map.getVertex("F"));
				 Date end = new Date();
					Notice(map.VertexArrayToPrint(map.route));	
				Result("Caculate by Brute Force answer is:"+len+" Time use:"+(end.getTime()-start.getTime())+"ms");
				
			}
		});
		final JButton btnLoaddata = new JButton("InitData");
		
		list.setVisible(true);
		
		mainLabel.setVisible(true);
		resultLabel.setVisible(true);
		btnMap1.setVisible(true);
		btnSelect.setVisible(false);
		initData.setVisible(true);
		
		list.removeAll();
		
		list.setFont(new Font("Serif", Font.PLAIN, 18));
		
		mainLabel.setText("");
		mainLabel.setVerticalAlignment(SwingConstants.TOP);
		mainLabel.setBackground(Color.DARK_GRAY);
		mainLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		mainLabel.setForeground(Color.BLUE);

		resultLabel.setText("");
		resultLabel.setVerticalAlignment(SwingConstants.TOP);
		resultLabel.setForeground(Color.RED);
		resultLabel.setFont(new Font("Serif", Font.BOLD, 20));
		resultLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		resultLabel.setBackground(Color.DARK_GRAY);

		init();
		map.label=mainLabel;
		this.mainLabel=mainLabel;
		this.resultLabel=resultLabel;
		this.list=list;
		Notice("LoadForm Finished.");
		/*
		JLabel l=mainLabel;
		String msg="LoadFinish";
		String add=df.format(new Date())+"-"+msg;
		l.setText("<html>"+add+"<br>"+l.getText());
*/
		
		list.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent arg0) {
				//x=-1;
			}
		});



		btnMap1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lab=1;
				if (loadData()) 	
					Notice("LoadData Finished."); 
				else 
					Notice("LoadData Failed.");
				refresh();
			}
		});
		

		initData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//mainLabel.setText("");
				int a[]=new int[n];
				list.removeAll();
				for (int i=0;i<n;i++)
				{
					if (r1.isSelected()) a[i]=(int) (Math.random() * 60000-30000);
					if (r2.isSelected()) a[i]=(int) (i);
					if (r3.isSelected()) a[i]=(int) (30000-i);
					if (r4.isSelected()) a[i]=(int)1;
					if (i<=100) list.add(String.valueOf(a[i]));
					if (i==100) list.add("...");
				}
				SortArray=new SortArray(a);
				SortArray.list=list;
				Notice("Create the sort array.");
				Notice("Reset Sort data");
				//SortArray.recover();
				
			}
		});


		

		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
	
		list.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			
			}
		});
		

		btnLoaddata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			map.destory();
			refresh();
			}
		});
		
		JButton btnGreedySearch = new JButton("Greedy");
		btnGreedySearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainLabel.setText("");
				 Date start = new Date();
				map.init(map.getVertex("A"), map.getVertex("F"));
				long len=map.Greedy(map.getVertex("A"), map.getVertex("F"));
				 Date end = new Date();
					Notice(map.VertexArrayToPrint(map.route));	
				Result("Caculate by Greedy answer is:"+len+" Time use:"+(end.getTime()-start.getTime())+"ms");
			}
		});
		
		JButton btnMap2 = new JButton("Map2");
		btnMap2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lab=2;
				if (loadData()) 	
					Notice("LoadData Finished."); 
				else 
					Notice("LoadData Failed.");
				refresh();
			}
		});
		
		JButton btnCircle = new JButton("Circle");
		btnCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainLabel.setText("");
				 Date start = new Date();
				map.init(map.getVertex("A"), map.getVertex("A"));
				long len=map.Round(map.getVertex("A"));
				 Date end = new Date();
					Notice(map.VertexArrayToPrint(map.route));	
				Result("Caculate Round answer is:"+len+" Time use:"+(end.getTime()-start.getTime())+"ms");
			}
		});
		
		JButton btnSort = new JButton("Sort");
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
				n=Integer.valueOf(JOptionPane.showInputDialog("Input the number of array")); 
				}
				catch (Exception e)
				{
					return;
				}
				int a[]=new int[n];
				list.removeAll();
				for (int i=0;i<n;i++)
				{
					if (r1.isSelected()) a[i]=(int) (Math.random() * 60000-30000);
					if (r2.isSelected()) a[i]=(int) (i);
					if (r3.isSelected()) a[i]=(int) (30000-i);
					if (r4.isSelected()) a[i]=(int)1;
					if (i<=100) list.add(String.valueOf(a[i]));
					if (i==100) list.add("...");
				}
				SortArray=new SortArray(a);
				SortArray.list=list;
				Notice("Create the sort array.");
			}
		});
		
		JButton btnBubbleSort = new JButton("Insertion Sort1");
		btnBubbleSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				 int reply=JOptionPane.showOptionDialog(null, "Select the momde", "Select", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
				 if (reply==-1)return;
				Notice("Start Sorting");
				 Date start = new Date();
	
				 if (reply==0) SortArray.bubbleSort();
				 if (reply==1) SortArray.bubbleSort2();
				 Date end = new Date();
					Notice("Finish Sorting");
				int[] a=SortArray.getResult();
				for (int i=0;i<n;i++)
					System.out.println(a[i]);
				
				Result("Array Num:"+a.length+" Time use:"+(end.getTime()-start.getTime())+"ms");
				
			}
		});
		
		JButton btnQuickSort = new JButton("Quick Sort");
		btnQuickSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Date start = new Date();
					Notice("Start Sorting");
				SortArray.quickSort();
				Date end = new Date();
				Notice("Finish Sorting");
				int[] a=SortArray.getResult();
				for (int i=0;i<n;i++)
					System.out.println(a[i]);
				Result("Array Num:"+a.length+" Time use:"+(end.getTime()-start.getTime())+"ms");
			}
		});
		
		JButton btnMegreSort = new JButton("Megre Sort");
		btnMegreSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				 Date start = new Date();
					Notice("Start Sorting");
				SortArray.mergeSort();
				Date end = new Date();
				Notice("Finish Sorting");
				int[] a=SortArray.getResult();
				for (int i=0;i<n;i++)
					System.out.println(a[i]);
				Result("Array Num:"+a.length+" Time use:"+(end.getTime()-start.getTime())+"ms");
		
				/*
				int[] m1=new int[10];
				int[] m2=new int[10];
				for (int i=0;i<10;i++)
				{
					m1[i]=2*i;
					m2[i]=2*i+1;
				}
				SortArray Sort=new SortArray(m1);
				int[] a=Sort.mSort(m1, m2);
				for (int i=0;i<20;i++)
					System.out.println(a[i]);
					*/
			}
		});
		
		JButton btnInsertSort = new JButton("Insertion Sort2");
		btnInsertSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				 int reply=JOptionPane.showOptionDialog(null, "Select the momde", "Select", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
				 if (reply==-1)return;
				 Notice("Start Sorting");
					 Date start = new Date();
			
					 if (reply==0) SortArray.insertSort();
					 if (reply==1) SortArray.binaryInsertSort();
					// Notice(String.valueOf(reply));

				Date end = new Date();
				Notice("Finish Sorting");
				int[] a=SortArray.getResult();
				for (int i=0;i<n;i++)
					System.out.println(a[i]);
				Result("Array Num:"+a.length+" Time use:"+(end.getTime()-start.getTime())+"ms");
			}
		});
		
		JButton btnBinarytree = new JButton("BinaryTree");
		btnBinarytree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				binaryTreeInit();
			}
		});
		
		JButton btnTreeTest = new JButton("Tree Test");
		btnTreeTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(Math.log(30000));
			}
		});
		
		JButton btnRandomMap = new JButton("Random Map");
		btnRandomMap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
				n=Integer.valueOf(JOptionPane.showInputDialog("Input the number of array")); 
				map=new Map();
				map.label=mainLabel;
				map.init(n,true);
				refresh();
				}
				catch (Exception e)
				{
					return;
				}
			
			}
		});
		
		JButton btnBfs = new JButton("BFS");
		btnBfs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				map.init();
				Notice("---BFS----");
				try
				{
					if (list.getSelectedIndex()>=0)
						map.BFS(map.getVertexNode().get(list.getSelectedIndex()-1));	
					else
						map.BFS(map.getVertexNode().get(0));
				}
				catch(Exception e)
				{
					return;
				}
				Notice("---Finish----");
			}
		});
		
		JButton btnDfs = new JButton("DFS");
		btnDfs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				map.init();
				Notice("---DFS----");
				try
				{
					if (list.getSelectedIndex()>=0)
						map.DFS(map.getVertexNode().get(list.getSelectedIndex()-1));	
					else
						map.DFS(map.getVertexNode().get(0));
				}
				catch(Exception e)
				{
					return;
				}
				Notice("---Finish----");
			}
		});
		
		JButton btnDijkstraHeap = new JButton("Dijkstra Heap");
		btnDijkstraHeap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//	DijHeap dh=new DijHeap(map);
				//n=list.getSelectedIndex();
				//n=Integer.valueOf(JOptionPane.showInputDialog("Input the number of index,Starts from last vertex")); 
				//if (n>0) Notice(String.valueOf(dh.dis[0][dh.ref[n]]));
			}
		});
		
		JButton btnRandomNdMap = new JButton("Random ND Map");
		btnRandomNdMap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
				n=Integer.valueOf(JOptionPane.showInputDialog("Input the number of array")); 
				map=new Map();
				map.label=mainLabel;
				map.init(n,false);
				
				refresh();
				}
				catch (Exception e)
				{
					return;
				}
			
			}
		});
		






		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(list, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(btnAdd, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
							.addComponent(btnEdit, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 101, Short.MAX_VALUE)
							.addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 84, Short.MAX_VALUE)
							.addComponent(btnSelect, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnDijkstraHeap)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(btnTreeTest, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
									.addComponent(btnInsertSort, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnMegreSort, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 123, Short.MAX_VALUE)
									.addComponent(btnBubbleSort, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnGoThrough, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 123, Short.MAX_VALUE)
									.addComponent(btnGreedySearch, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 123, Short.MAX_VALUE)
									.addComponent(btnDijkstra, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 123, Short.MAX_VALUE)
									.addComponent(btnCircle, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 123, Short.MAX_VALUE)
									.addComponent(btnQuickSort, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 123, Short.MAX_VALUE))
								.addGap(18))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(btnBfs)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnDfs)
								.addGap(4))))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(mainLabel, GroupLayout.PREFERRED_SIZE, 241, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(resultLabel, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(28)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
											.addComponent(btnMap2, GroupLayout.PREFERRED_SIZE, 95, Short.MAX_VALUE)
											.addComponent(btnMap1, GroupLayout.PREFERRED_SIZE, 95, Short.MAX_VALUE)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(btnSort, GroupLayout.PREFERRED_SIZE, 95, Short.MAX_VALUE)
												.addPreferredGap(ComponentPlacement.RELATED))
											.addComponent(r1, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
										.addGap(11))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(r4)
											.addComponent(r3, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
											.addComponent(initData)
											.addComponent(r2, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
										.addContainerGap()))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnBinarytree)
									.addContainerGap()))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnRandomMap)
								.addContainerGap()))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnRandomNdMap)
							.addContainerGap())))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnLoaddata)
					.addContainerGap(647, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(14)
					.addComponent(btnLoaddata)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(mainLabel, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(btnMap1)
										.addGap(11)
										.addComponent(btnMap2)
										.addGap(17)
										.addComponent(btnSort)
										.addGap(15)
										.addComponent(r1)
										.addGap(5)
										.addComponent(r2)
										.addGap(7)
										.addComponent(r3)
										.addGap(7)
										.addComponent(r4)
										.addGap(9)
										.addComponent(initData)
										.addGap(21)
										.addComponent(btnBinarytree)
										.addGap(42)
										.addComponent(btnRandomNdMap)
										.addGap(7)
										.addComponent(btnRandomMap)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnGoThrough)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnGreedySearch)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnDijkstra)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnCircle)
									.addGap(20)
									.addComponent(btnBubbleSort)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnInsertSort)
									.addGap(10)
									.addComponent(btnMegreSort)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnQuickSort)
									.addGap(18)
									.addComponent(btnTreeTest)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(resultLabel, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
												.addComponent(btnBfs)
												.addComponent(btnDfs))
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(btnDijkstraHeap)))))
							.addGap(40))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(list, GroupLayout.PREFERRED_SIZE, 343, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnEdit)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAdd)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnRemove)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSelect)
					.addGap(4))
		);

		contentPane.setLayout(gl_contentPane);
	
	}
	public static void binaryTreeInit()
	{
	 	BinarySearchTree bst=new BinarySearchTree();
			bst.insert(new BinaryTreeNode(50));
			bst.insert(new BinaryTreeNode(20));
			bst.insert(new BinaryTreeNode(15));
			bst.insert(new BinaryTreeNode(70));
			bst.insert(new BinaryTreeNode(30));
			bst.insert(new BinaryTreeNode(60));
			bst.insert(new BinaryTreeNode(80));
			bst.insert(new BinaryTreeNode(40));
			bst.insert(new BinaryTreeNode(5));
			bst.print();
			bst.remove(bst.find(20));
			System.out.println();
			bst.print();
	}
	public static boolean loadData()
	{
		map.destory();
		//if (load) return false;
		if (lab==1)
		{
		VertexNode A=new VertexNode("A");
		VertexNode B=new VertexNode("B");
		VertexNode C=new VertexNode("C");
		VertexNode D=new VertexNode("D");
		VertexNode E=new VertexNode("E");
		VertexNode F=new VertexNode("F");
		EdgeNode AB=new EdgeNode("A","B",4);
		EdgeNode AC=new EdgeNode("A","C",3);
		EdgeNode AE=new EdgeNode("A","E",7);
		EdgeNode CE=new EdgeNode("C","E",8);
		EdgeNode ED=new EdgeNode("E","D",2);
		EdgeNode CD=new EdgeNode("C","D",11);
		EdgeNode BC=new EdgeNode("B","C",6);
		EdgeNode EG=new EdgeNode("E","G",5);
		EdgeNode DG=new EdgeNode("D","G",10);
		EdgeNode DF=new EdgeNode("D","F",2);
		EdgeNode GF=new EdgeNode("D","F",3);
		
		map.insertVertex(A);
		map.insertVertex(B);
		map.insertVertex(C);
		map.insertVertex(D);
		map.insertVertex(E);
		map.insertVertex(F);
		map.insertEdge(AB);
		map.insertEdge(AC);
		map.insertEdge(AE);
		map.insertEdge(CE);
		map.insertEdge(ED);
		map.insertEdge(CD);
		map.insertEdge(BC);
		map.insertEdge(EG);
		map.insertEdge(DG);
		map.insertEdge(DF);
		map.insertEdge(GF);
		
		load=true;
		return true;
		}
		if (lab==2)
		{
			VertexNode A=new VertexNode("A");
			VertexNode B=new VertexNode("B");
			VertexNode C=new VertexNode("C");
			VertexNode D=new VertexNode("D");
			EdgeNode AB=new EdgeNode("A","B",4);
			EdgeNode AC=new EdgeNode("A","C",3);
			EdgeNode AD=new EdgeNode("A","D",7);
			EdgeNode BC=new EdgeNode("B","C",8);
			EdgeNode BD=new EdgeNode("B","D",7);
			EdgeNode CD=new EdgeNode("C","D",8);
			
			map.insertVertex(A);
			map.insertVertex(B);
			map.insertVertex(C);
			map.insertVertex(D);
			map.insertEdge(AB);
			map.insertEdge(AC);
			map.insertEdge(AD);
			map.insertEdge(BC);
			map.insertEdge(BD);
			map.insertEdge(CD);
		}
		
		
		return false;

	}
	public static void ioOut() throws IOException
	{
		File file=new File("C:/Test/record.txt");
		Writer writer=new OutputStreamWriter(new FileOutputStream(file,false),"GBK");
		writer.write("");

		writer.close();
	}
	
	public static void ioIn() throws IOException
	{
		File file=new File("C:/Test/record.txt");
		InputStreamReader read= new InputStreamReader(new  FileInputStream(file),"GBK");
		BufferedReader reader=new BufferedReader(read);
		String notice=String.valueOf(reader.readLine());
		reader.close();
	}
	public static void init() throws IOException
	{
		map=new Map();
		load=false;
	}

	public static boolean contain(Object[] Array,Object find)
	{
		for (Object scanner:Array)
			if (scanner==find) return true;
		return false;
	}
	public void Notice(String msg)
	{
		DateFormat df= new SimpleDateFormat("HH:mm:ss.SSS"); 
		 mainLabel.setText("<html>"+df.format(new Date())+"-"+msg+"<br>"+mainLabel.getText());
		System.out.println(df.format(new Date())+"-"+msg);
	}
	public void Result(String msg)
	{
		DateFormat df= new SimpleDateFormat("HH:mm:ss.SSS"); 
		resultLabel.setText("<html>"+msg);
		System.out.println(df.format(new Date())+"-"+msg);
	}
	public void refresh()
	{

		list.removeAll();
		list.add("VertexNodes:");
		for (VertexNode Scanner:map.getVertexNode())
			list.add(Scanner.getName());
		list.add("EdgeNodes:");
		for (EdgeNode Scanner:map.getEdgeNode())
			list.add(Scanner.getDetail());
	}
}

