package ru.dolika.timetable.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
	private CollectionListModel<Teacher> listModel;

	final Set<Teacher> teachers;

	/**
	 * @param arg0
	 * @throws HeadlessException
	 */
	public TeacherViewer(final Set<Teacher> t) throws HeadlessException {
		super("Учителя");
		this.teachers = t;
		// this.setType(Window.Type.UTILITY);

		SwingUtilities.invokeLater(this::createGUI);
	}

	class CollectionListModel<B> extends AbstractListModel<B> {

		private static final long serialVersionUID = -4432282288056499582L;
		private final Collection<B> collection;

		public CollectionListModel(Collection<B> c) {
			this.collection = c;
		}

		@Override
		public int getSize() {
			return this.collection.size();
		}

		@Override
		public B getElementAt(int index) {
			return this.collection.stream().sorted().skip(index).findFirst().orElse(null);
		}

		public void add(B o) {
			this.collection.add(o);
			fireContentsChanged(this, 0, this.collection.size());
		}

		public void remove(B o) {
			this.collection.remove(o);
			fireContentsChanged(this, 0, this.collection.size());
		}

		public void update() {
			fireContentsChanged(this, 0, this.collection.size());
		}
	}

	public void createGUI() {
		this.listModel = new CollectionListModel<>(this.teachers);
		this.list = new JList<>(this.listModel);
		this.list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane scrollingPane = new JScrollPane(this.list);

		getContentPane().add(scrollingPane, BorderLayout.CENTER);

		this.panel = new JPanel();
		getContentPane().add(this.panel, BorderLayout.SOUTH);
		this.panel.setLayout(new GridLayout(0, 3, 8, 8));

		JButton btnAddbutton = new JButton("Добавить");
		this.panel.add(btnAddbutton);

		JButton btnDeletebutton = new JButton("Удалить");
		this.panel.add(btnDeletebutton);

		JButton btnEditButton = new JButton("Редактировать");
		this.panel.add(btnEditButton);

		this.pack();

		ActionListener addDeleteEditAction = (e) -> {
			Object source = e.getSource();
			Teacher selectedTeacher;
			if (btnAddbutton.equals(source)) {
				// как-то нужно добавить сюда элемент...
				String firstName = JOptionPane.showInputDialog(TeacherViewer.this, "Имя");
				if (firstName == null)
					return;
				String middleName = JOptionPane.showInputDialog(TeacherViewer.this, "Отчество");
				if (middleName == null)
					return;
				String lastName = JOptionPane.showInputDialog(TeacherViewer.this, "Фамилия");
				if (lastName == null)
					return;

				selectedTeacher = new Teacher(firstName, middleName, lastName);

				System.out.println("Добавлен: " + selectedTeacher);

				this.onAddList.forEach((c) -> c.accept(selectedTeacher));
				this.listModel.add(selectedTeacher);
			} else if (btnDeletebutton.equals(source)) {
				selectedTeacher = this.list.getSelectedValue();
				if (selectedTeacher == null)
					return;

				if (JOptionPane.showConfirmDialog(TeacherViewer.this,
						"Вы уверены, что хотите удалить учителя?\r\n" + "Операцию отменить невозможно",
						"Удаление учителя", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {

					System.out.println("Deleted : " + selectedTeacher);

					this.onDeleteList.forEach((c) -> c.accept(selectedTeacher));
					this.listModel.remove(selectedTeacher);
				}
			} else if (btnEditButton.equals(source)) {
				selectedTeacher = this.list.getSelectedValue();
				if (selectedTeacher == null)
					return;

				String firstName = JOptionPane.showInputDialog(TeacherViewer.this, "Имя", selectedTeacher.getName());
				if (firstName == null)
					return;
				String middleName = JOptionPane.showInputDialog(TeacherViewer.this, "Отчество",
						selectedTeacher.getMiddleName());
				if (middleName == null)
					return;
				String lastName = JOptionPane.showInputDialog(TeacherViewer.this, "Фамилия",
						selectedTeacher.getLastName());
				if (lastName == null)
					return;

				selectedTeacher.setName(firstName);
				selectedTeacher.setMiddleName(middleName);
				selectedTeacher.setLastName(lastName);

				this.listModel.update();
			}
		};
		btnAddbutton.addActionListener(addDeleteEditAction);
		btnDeletebutton.addActionListener(addDeleteEditAction);
		btnEditButton.addActionListener(addDeleteEditAction);

	}

	final List<Consumer<Teacher>> onDeleteList = new ArrayList<>();
	final List<Consumer<Teacher>> onAddList = new ArrayList<>();

	/**
	 * @param e
	 * @return
	 * @see java.util.List#add(java.lang.Object)
	 */
	public boolean addOnDeleteActionListener(Consumer<Teacher> e) {
		return this.onDeleteList.add(e);
	}

	/**
	 * @param o
	 * @return
	 * @see java.util.List#remove(java.lang.Object)
	 */
	public boolean removeonDeleteActionListener(Object o) {
		return this.onDeleteList.remove(o);
	}

	/**
	 * @param e
	 * @return
	 * @see java.util.List#add(java.lang.Object)
	 */
	public boolean addOnAddActionListener(Consumer<Teacher> e) {
		return this.onAddList.add(e);
	}

	/**
	 * @param o
	 * @return
	 * @see java.util.List#remove(java.lang.Object)
	 */
	public boolean removeOnAddActionListener(Object o) {
		return this.onAddList.remove(o);
	}
}
