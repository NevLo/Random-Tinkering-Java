package me.gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

@SuppressWarnings("serial")
public class WindowTests extends JFrame {

	JFrame mainFrame;
	JSplitPane split;
	JSplitPane splTop;
	JPanel pnlTopLeft;
	JPanel pnlTopRight;
	JPanel pnlBot;
	JButton btnNew;
	JButton btnEdit;
	static ArrayList<JLabel> lblArrNurses;
	static ArrayList<JLabel> lblArrDocs;
	static ArrayList<JLabel> lblArrCNAs;
	static ArrayList<JLabel> room_bed;
	final int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height - 40;
	static File file = new File("Patients.txt");
	static Scanner scan;

	public WindowTests() {
		setUndecorated(true);
		setTitle("Frame Testing");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(300, HEIGHT));
		setBounds(0, 0, getPreferredSize().width, getPreferredSize().height);

		split = new JSplitPane();
		splTop = new JSplitPane();
		split.setOrientation(0);
		split.setDividerLocation(HEIGHT - 100);
		splTop.setDividerLocation(150);
		pnlBot = new JPanel();
		pnlTopLeft = new JPanel();
		pnlTopRight = new JPanel();
		btnEdit = new JButton("Edit");
		btnNew = new JButton("New");
		pnlBot.setLayout(new GridLayout(0, 2, 0, 0));

		pnlBot.add(btnEdit);
		pnlBot.add(btnNew);

		split.setBottomComponent(pnlBot);
		split.setTopComponent(splTop);

		splTop.setBottomComponent(pnlTopRight);
		splTop.setTopComponent(pnlTopLeft);
		pnlTopLeft.setLayout(new GridLayout(20, 4));
		pnlTopRight.setLayout(new GridLayout(20, 4));
		for (int i = 0; i < 20; i++) {
			pnlTopLeft.add(room_bed.get(i));
		}

		for (int i = 0; i < 20; i++) {
			pnlTopLeft.add(lblArrDocs.get(i));
		}
		for (int i = 0; i < 20; i++) {
			pnlTopLeft.add(lblArrNurses.get(i));
		}
		for (int i = 0; i < 20; i++) {
			pnlTopLeft.add(lblArrCNAs.get(i));
		}
		for (int i = 20; i < 40; i++) {
			pnlTopRight.add(room_bed.get(i));
		}
		for (int i = 20; i < 40; i++) {
			pnlTopRight.add(lblArrDocs.get(i));
		}
		for (int i = 20; i < 40; i++) {
			pnlTopRight.add(lblArrNurses.get(i));
		}
		for (int i = 20; i < 40; i++) {
			pnlTopRight.add(lblArrCNAs.get(i));
		}

		getContentPane().add(split);

		pack();
	}

	public static void main(String[] args) throws IOException {
		lblArrNurses = new ArrayList<JLabel>();
		lblArrDocs = new ArrayList<JLabel>();
		lblArrCNAs = new ArrayList<JLabel>();
		room_bed = new ArrayList<JLabel>();
		scan = new Scanner(file);
		fillArrays(scan);

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new WindowTests().setVisible(true);
			}
		});
	}

	public static void fillArrays(Scanner s) {
		while (s.hasNextLine()) {
			String temp = s.nextLine();
			String room = temp.substring(0, temp.indexOf("|"));
			temp = temp.replaceFirst(room, "");
			temp = temp.substring(1);
			room_bed.add(new JLabel(room));

			String doc = temp.substring(0, temp.indexOf("|"));
			temp = temp.replaceFirst(doc, "");
			temp = temp.substring(1);
			lblArrDocs.add(new JLabel(doc));

			String nurse = temp.substring(0, temp.indexOf("|"));
			temp = temp.replaceFirst(nurse, "");
			temp = temp.substring(1);
			lblArrNurses.add(new JLabel(nurse));

			String cna = temp.substring(0, temp.indexOf(";"));
			lblArrCNAs.add(new JLabel(cna));
		}

	}
}
