package ru.dolika.timetable.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Window;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

import ru.dolika.timetable.models.Teacher;

public class TeacherViewer extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JList<Teacher> list;

	final List<Teacher> teachers;

	/**
	 * @param arg0
	 * @throws HeadlessException
	 */
	public TeacherViewer(final List<Teacher> t) throws HeadlessException {
		super("Учителя");
		this.teachers = t;
		SwingUtilities.invokeLater(this::createGUI);
	}

	public void createGUI() {
		this.setType(Window.Type.UTILITY);
		this.list = new JList<>(new AbstractListModel<Teacher>() {
			private static final long serialVersionUID = 1646546827987L;

			@Override
			public int getSize() {
				return TeacherViewer.this.teachers.size();
			}

			@Override
			public Teacher getElementAt(int i) {
				return TeacherViewer.this.teachers.get(i);
			}
		});
		this.list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		getContentPane().add(this.list, BorderLayout.CENTER);

		this.panel = new JPanel();
		getContentPane().add(this.panel, BorderLayout.SOUTH);
		this.panel.setLayout(new GridLayout(0, 2, 8, 8));

		JButton btnOKbutton = new JButton("ОК");

		this.panel.add(btnOKbutton);

		JButton btnEditButton = new JButton("Редактировать");
		this.panel.add(btnEditButton);

	}

}
