import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.Font;
import java.awt.event.*;

public class GUIPractice
{
	public static void main(String[] args)
	{
/*
		//JOptionPane
		String fistNumber = JOptionPane.showInputDialog("Enter 1st number: ");

		String secondNumber = JOptionPane.showInputDialog("Enter 2nd number: ");

		int num1 = Integer.parseInt(fistNumber);
		int num2 = Integer.parseInt(secondNumber);
		int sum = num1 + num2;

		JOptionPane.showMessageDialog(null, "Sum of " + num1 + " and " + num2 + " is: " + sum,"Sum of Integers",JOptionPane.PLAIN_MESSAGE);

		//JLabel
		LabelFrame labelFrame = new LabelFrame();


		//JTextField
		TextFieldFrame textfields=new TextFieldFrame();
		textfields.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textfields.setSize(120,220);
		textfields.setResizable(false);
		textfields.setVisible(true);

		//JButton
		ButtonFrame buttonFrame=new ButtonFrame();
		buttonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buttonFrame.setSize(250,250);
		buttonFrame.setVisible(true);

		CheckBoxFrame checkBoxFrame=new CheckBoxFrame();
		checkBoxFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		checkBoxFrame.setSize(275,100);
		checkBoxFrame.setVisible(true);

		RadioButtonFrame radioButtonFrame = new RadioButtonFrame();

		ComboBoxFrame comboBoxFrame=new ComboBoxFrame();

		SingleSelectionListFrame singleSelectionListFrame=new SingleSelectionListFrame();

		MultipleSelectionListFrame multipleSelectionListFrame=new MultipleSelectionListFrame();

		TextAreaFrame textAreaFrame=new TextAreaFrame();

		MouseTrackerFrame mouseTrackerFrame = new MouseTrackerFrame();

		MouseDetailsFrame mouseDetailsFrame=new MouseDetailsFrame();

		KeyDemoFrame keyDemoFrame=new KeyDemoFrame();

		FlowLayoutFrame flowLayoutFrame=new FlowLayoutFrame();

		BorderLayoutFrame borderLayoutFrame=new BorderLayoutFrame();

		GridLayoutFrame gridLayoutFrame=new GridLayoutFrame();*/

		MenuFrame menuFrame=new MenuFrame();
	}
}

class LabelFrame
{
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;

	LabelFrame()
	{
		JFrame frame = new JFrame("Testing JLabel");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(260, 180);
		frame.setLayout(new FlowLayout());

		label1 = new JLabel("Label with text");
		label1.setToolTipText("This is label1");
		frame.add(label1);

		Icon bug = new ImageIcon(getClass().getResource("terminal.png"));
		label2 = new JLabel("Label with text and icon", bug,
				SwingConstants.LEFT);
		label2.setToolTipText("This is label2");
		frame.add(label2);

		label3 = new JLabel();
		label3.setText("Label with icon and text at bottom");
		label3.setIcon(bug);
		label3.setHorizontalTextPosition(SwingConstants.CENTER);
		label3.setVerticalTextPosition(SwingConstants.BOTTOM);
		label3.setToolTipText("This is label3");
		frame.add(label3);

		frame.setVisible(true);
	}
}

class TextFieldFrame extends JFrame
{
	private JTextField textField1, textField2, textField3;
	private JPasswordField passwordField;

	TextFieldFrame()
	{
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setSize(840, 620);
		super("Testing JTextField and JPasswordField");
		setLayout(new FlowLayout());

		//textfield with 10 columns
		textField1 = new JTextField(10);
		add(textField1);

		//textfield with default text
		textField2 = new JTextField("Enter text here");
		add(textField2);

		//text field with default text and 10 columns
		textField3 = new JTextField("Uneditable text field", 10);
		textField3.setEditable(false); //disable editing
		add(textField3);

		//passwordfield with JLabel
		JLabel passwordLabel = new JLabel("Enter Password:");
		passwordField = new JPasswordField(10);
		add(passwordLabel);
		add(passwordField);

		//register textField handlers
		TextFieldHandler handler = new TextFieldHandler();
		textField1.addActionListener(handler);
		textField2.addActionListener(handler);
		textField3.addActionListener(handler);
		passwordField.addActionListener(handler);

		//setVisible(true);

	}

	private class TextFieldHandler implements ActionListener
	{
		@Override public void actionPerformed(ActionEvent e)
		{
			String st = "";

			//if user press enter in textField1
			if (e.getSource() == textField1)
				st = String.format("textField1: %s", e.getActionCommand());

				//if user press enter in textField2
			else if (e.getSource() == textField2)
				st = String.format("textField2: %s", e.getActionCommand());

				//if user press enter in textField3
			else if (e.getSource() == textField3)
				st = String.format("textField3: %s", e.getActionCommand());

				//if user press enter in textField3
			else if (e.getSource() == passwordField)
				st = String.format("passwordField: %s", e.getActionCommand());
			//for showing JTextField contents
			JOptionPane.showMessageDialog(null, st);
		}
	}
}

class ButtonFrame extends JFrame
{
	private JButton plainButton;
	private JButton fancyButton1;

	ButtonFrame()
	{
		super("Testing JButton");
		setLayout(new FlowLayout());

		plainButton = new JButton("Plain Button");
		add(plainButton);

		Icon code = new ImageIcon(getClass().getResource("coding.png"));
		fancyButton1 = new JButton("Fancy Button", code);
		Icon terminal = new ImageIcon(getClass().getResource("terminal.png"));
		fancyButton1.setRolloverIcon(
				terminal); //new icon when mouse comes over button
		add(fancyButton1);

		ButtonHandler handler = new ButtonHandler();
		plainButton.addActionListener(handler);
		fancyButton1.addActionListener(handler);
	}

	private class ButtonHandler implements ActionListener
	{
		@Override public void actionPerformed(ActionEvent e)
		{
			JOptionPane.showMessageDialog(ButtonFrame.this,
					String.format("You pressed: %s", e.getActionCommand()));
		}
	}
}

class CheckBoxFrame extends JFrame
{
	private JTextField textField;
	private JCheckBox boldJCheckBox;
	private JCheckBox italicJCheckBox;

	CheckBoxFrame()
	{
		super("JCheckBox Test");
		setLayout(new FlowLayout());

		textField = new JTextField("Watch the font style change!", 20);
		textField.setFont(new Font("Serif", Font.PLAIN, 14));
		add(textField);

		boldJCheckBox = new JCheckBox("Bold");
		italicJCheckBox = new JCheckBox("Italic");
		add(boldJCheckBox);
		add(italicJCheckBox);

		CheckBoxHandler handler = new CheckBoxHandler();
		boldJCheckBox.addItemListener(handler);
		italicJCheckBox.addItemListener(handler);

	}

	private class CheckBoxHandler implements ItemListener
	{
		@Override public void itemStateChanged(ItemEvent e)
		{
			Font font = null; //stores the new font

			if (boldJCheckBox.isSelected() && italicJCheckBox.isSelected())
				font = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
			else if (boldJCheckBox.isSelected())
				font = new Font("Serif", Font.BOLD, 14);
			else if (italicJCheckBox.isSelected())
				font = new Font("Serif", Font.ITALIC, 14);
			else
				font = new Font("Serif", Font.PLAIN, 14);

			textField.setFont(font);
		}
	}
}

class RadioButtonFrame extends JFrame
{
	private JTextField textField;
	private Font plainFont;
	private Font boldFont;
	private Font italicFont;
	private Font boldItalicFont;
	private JRadioButton plainJRadioButton;
	private JRadioButton boldJRadioButton;
	private JRadioButton italicJRadioButton;
	private JRadioButton boldItalicRadioButton;
	private ButtonGroup radioGroup;

	RadioButtonFrame()
	{
		super("JRadioButton Test");
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 100);

		textField = new JTextField("Watch the font style change!", 25);
		add(textField);

		plainFont = new Font("Serif", Font.PLAIN, 14);
		boldFont = new Font("Serif", Font.BOLD, 14);
		italicFont = new Font("Serif", Font.ITALIC, 14);
		boldItalicFont = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
		//set initial font to plain
		textField.setFont(plainFont);

		plainJRadioButton = new JRadioButton("Plain", true);
		boldJRadioButton = new JRadioButton("Bold", false);
		italicJRadioButton = new JRadioButton("Italic", false);
		boldItalicRadioButton = new JRadioButton("Bold/Italic", false);
		add(plainJRadioButton);
		add(boldItalicRadioButton);
		add(italicJRadioButton);
		add(boldItalicRadioButton);

		//create logical relation between JRadioButtons
		radioGroup = new ButtonGroup();
		radioGroup.add(plainJRadioButton);
		radioGroup.add(boldJRadioButton);
		radioGroup.add(italicJRadioButton);
		radioGroup.add(boldItalicRadioButton);

		plainJRadioButton.addItemListener(new RadioButtonHandler(plainFont));
		boldJRadioButton.addItemListener(new RadioButtonHandler(boldFont));
		italicJRadioButton.addItemListener(new RadioButtonHandler(italicFont));
		boldItalicRadioButton
				.addItemListener(new RadioButtonHandler(boldItalicFont));

		setVisible(true);
	}

	class RadioButtonHandler implements ItemListener
	{
		private Font font;

		public RadioButtonHandler(Font f)
		{
			font = f; //set the font of this listener
		}

		@Override public void itemStateChanged(ItemEvent e)
		{
			textField.setFont(font);
		}
	}
}

class ComboBoxFrame extends JFrame
{
	private JComboBox imagesJComboBox;
	private JLabel label;
	private JLabel iconLabel;

	private static String[] names = { "camera.png", "calculator.png",
			"coding.png", "terminal.png" };
	private Icon[] icons = { new ImageIcon(getClass().getResource(names[0])),
			new ImageIcon(getClass().getResource(names[1])),
			new ImageIcon(getClass().getResource(names[2])),
			new ImageIcon(getClass().getResource(names[3])) };

	private static String[] listNames = { "Camera", "Calculator", "Desktop PC",
			"Webcam" };

	ComboBoxFrame()
	{
		super("Testing JComboBox");
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 220);

		label = new JLabel("Select the device:");
		add(label);

		imagesJComboBox = new JComboBox(listNames);
		imagesJComboBox.setMaximumRowCount(3); //display 3 rows

		imagesJComboBox
				.addItemListener(new ItemListener() //anonymous inner class
				{
					@Override public void itemStateChanged(ItemEvent e)
					{
						if (e.getStateChange() == ItemEvent.SELECTED)
							iconLabel.setIcon(
									icons[imagesJComboBox.getSelectedIndex()]);
					}
				});
		add(imagesJComboBox);

		iconLabel = new JLabel(icons[0]);
		add(iconLabel);

		setVisible(true);
	}
}

class SingleSelectionListFrame extends JFrame
{
	private JList colorsJlist;
	private static final String[] colorsNames = { "Black", "Blue", "Cyan",
			"Dark Grey", "Grey", "Light Grey", "Green", "Red", "Orange",
			"Yellow", "Magenta", "Pink", "White" };
	private static final Color[] colors = { Color.BLACK, Color.BLUE, Color.CYAN,
			Color.DARK_GRAY, Color.GRAY, Color.LIGHT_GRAY, Color.GREEN,
			Color.RED, Color.ORANGE, Color.YELLOW, Color.MAGENTA, Color.PINK,
			Color.WHITE };

	SingleSelectionListFrame()
	{
		super("Testing JList (Single Selection)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setSize(350, 150);

		colorsJlist = new JList(colorsNames);
		colorsJlist.setVisibleRowCount(5);
		add(new JScrollPane(
				colorsJlist)); //adding JScrollPane to scroll the list beyond 5 rows

		colorsJlist.addListSelectionListener(new ListSelectionListener()
		{
			@Override public void valueChanged(ListSelectionEvent e)
			{
				getContentPane()
						.setBackground(colors[colorsJlist.getSelectedIndex()]);
			}
		});
		setVisible(true);
	}
}

class MultipleSelectionListFrame extends JFrame
{
	private JList colorsJlist;
	private JList copyJlist;
	private JButton copyJButton;
	private static final String[] colorsNames = { "Black", "Blue", "Cyan",
			"Dark Grey", "Grey", "Light Grey", "Green", "Red", "Orange",
			"Yellow", "Magenta", "Pink", "White" };
	private static final Color[] colors = { Color.BLACK, Color.BLUE, Color.CYAN,
			Color.DARK_GRAY, Color.GRAY, Color.LIGHT_GRAY, Color.GREEN,
			Color.RED, Color.ORANGE, Color.YELLOW, Color.MAGENTA, Color.PINK,
			Color.WHITE };

	MultipleSelectionListFrame()
	{
		super("Testing JList (Multiple Selection)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setSize(350, 150);

		colorsJlist = new JList(colorsNames);
		colorsJlist.setVisibleRowCount(5);
		colorsJlist.setSelectionMode(
				ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		add(new JScrollPane(
				colorsJlist)); //adding JScrollPane to scroll the list beyond 5 rows

		copyJButton = new JButton("Copy >>>");
		add(copyJButton);
		JButtonHandler handler = new JButtonHandler();
		copyJButton.addActionListener(handler);

		copyJlist = new JList();
		copyJlist.setVisibleRowCount(5);
		copyJlist.setFixedCellWidth(100);
		copyJlist.setFixedCellHeight(15);
		copyJlist
				.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		add(new JScrollPane(copyJlist));
		/*colorsJlist.addListSelectionListener(new ListSelectionListener()
		{
			@Override public void valueChanged(ListSelectionEvent e)
			{
				getContentPane()
						.setBackground(colors[colorsJlist.getSelectedIndex()]);
			}
		});*/
		setVisible(true);
	}

	private class JButtonHandler implements ActionListener
	{
		@Override public void actionPerformed(ActionEvent e)
		{
			copyJlist.setListData(colorsNames);
		}
	}
}

class TextAreaFrame extends JFrame
{
	private JTextArea textArea1;
	private JTextArea textArea2;
	private JButton copyButton;

	TextAreaFrame()
	{
		super("TestArea Demo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(425, 200);

		Box box = Box
				.createHorizontalBox(); //this arranges components from left to right
		String demo = "This is a demo string to\n"
				+ "illustrate copying text\nfrom one TestArea to \n"
				+ "another TextArea using an\nexternal event\n";

		textArea1=new JTextArea(demo,10,15);
		box.add(new JScrollPane(textArea1));

		copyButton=new JButton("Copy >>>");
		box.add(copyButton);
		copyButton.addActionListener(new ActionListener()
		{
			@Override public void actionPerformed(ActionEvent e)
			{
				textArea2.setText(textArea1.getSelectedText());
			}
		});

		textArea2=new JTextArea(10,15);
		textArea2.setEditable(false);
		box.add(new JScrollPane(textArea2));

		add(box);

		setVisible(true);
	}
}

class MouseTrackerFrame extends JFrame
{
	private JPanel mousePanel;
	private JLabel statusLabel;

	MouseTrackerFrame()
	{
		super("Demonstrating Mouse Events");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(300, 200);

		mousePanel = new JPanel();
		mousePanel.setBackground(Color.WHITE);
		add(mousePanel, BorderLayout.CENTER);
		statusLabel = new JLabel("Mouse outside JPanel");
		add(statusLabel, BorderLayout.SOUTH);

		setVisible(true);

		MouseHandler handler = new MouseHandler();
		mousePanel.addMouseListener(handler);
		mousePanel.addMouseMotionListener(handler);
	}

	private class MouseHandler implements MouseListener, MouseMotionListener
	{
		@Override public void mouseClicked(MouseEvent e)
		{
			statusLabel.setText(
					String.format("Clicked at [%d, %d]", e.getX(), e.getY()));
		}

		@Override public void mousePressed(MouseEvent e)
		{
			statusLabel.setText(
					String.format("Pressed at [%d, %d]", e.getX(), e.getY()));
		}

		@Override public void mouseReleased(MouseEvent e)
		{
			statusLabel.setText(
					String.format("Released at [%d, %d]", e.getX(), e.getY()));
		}

		@Override public void mouseEntered(MouseEvent e)
		{
			statusLabel.setText(
					String.format("Mouse entered at [%d, %d]", e.getX(),
							e.getY()));
			mousePanel.setBackground(Color.GREEN);
		}

		@Override public void mouseExited(MouseEvent e)
		{
			statusLabel.setText("Mouse is outside the JPanel");
			mousePanel.setBackground(Color.WHITE);
		}

		@Override public void mouseDragged(MouseEvent e)
		{
			statusLabel.setText(
					String.format("Mouse dragged at [%d, %d]", e.getX(),
							e.getY()));
		}

		@Override public void mouseMoved(MouseEvent e)
		{
			statusLabel.setText(
					String.format("Mouse moved at [%d, %d]", e.getX(),
							e.getY()));
		}
	}
}

class MouseDetailsFrame extends JFrame
{
	private String details;
	private JLabel statusBar;

	MouseDetailsFrame()
	{
		super("Mouse clicks and buttons");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 200);

		statusBar = new JLabel("Click the mouse");
		add(statusBar, BorderLayout.SOUTH);

		addMouseListener(new MouseClickHandler());
		setVisible(true);
	}

	private class MouseClickHandler extends MouseAdapter
	{
		@Override public void mouseClicked(MouseEvent e)
		{
			details = String.format("Clicked %d time(s) ", e.getClickCount());

			if (e.isMetaDown()) //right mouse button
				details += "with right mouse button at [" + e.getX() + ", " + e
						.getY() + "]";
			else if (e.isAltDown()) //middle mouse button
				details += "with center mouse button at [" + e.getX() + ", " + e
						.getY() + "]";
			else
				details += "with left mouse button at [" + e.getX() + ", " + e
						.getY() + "]"; //left mouse button

			statusBar.setText(details);
		}
	}
}

class KeyDemoFrame extends JFrame implements KeyListener
{
	private String line1="";
	private String line2="";
	private String line3="";
	private JTextArea textArea;

	KeyDemoFrame()
	{
		super("Demonstrating Keystroke Events");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350,100);

		textArea=new JTextArea(10,15);
		textArea.setText("Press any key on the keyboard. . .");
		textArea.setEnabled(false);
		textArea.setDisabledTextColor(Color.BLACK);
		add(textArea);

		addKeyListener(this);

		setVisible(true);
	}

	public void keyPressed(KeyEvent e)
	{
		line1=String.format("Key pressed: %s",KeyEvent.getKeyText(e.getKeyCode()));
		setLine2andLine3(e);
	}

	public void keyReleased(KeyEvent e)
	{
		line1=String.format("Key released: %s",KeyEvent.getKeyText(e.getKeyCode()));
		setLine2andLine3(e);
	}

	public void keyTyped(KeyEvent e)
	{
		line1=String.format("Key typed: %s",e.getKeyChar());
		setLine2andLine3(e);
	}

	private void setLine2andLine3(KeyEvent e)
	{
		line2=String.format("This key is %san action key",(e.isActionKey() ? "" : "not "));
		String temp=KeyEvent.getKeyModifiersText(e.getModifiers());
		line3=String.format("Modifier keys pressed: %s",temp.equals("") ? "none" : temp);

		textArea.setText(String.format("%s\n%s\n%s\n",line1,line2,line3));
	}
}

class FlowLayoutFrame extends JFrame
{
	private JButton leftJButton;
	private JButton centerJButton;
	private JButton rightJButton;
	private FlowLayout flowLayout;
	private Container container;

	FlowLayoutFrame()
	{
		super("FlowLayout Demo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 75);

		flowLayout = new FlowLayout();
		container = getContentPane(); //get container to layout
		setLayout(flowLayout);

		leftJButton = new JButton("Left");
		add(leftJButton);
		leftJButton.addActionListener(new ActionListener()
		{
			@Override public void actionPerformed(ActionEvent e)
			{
				flowLayout.setAlignment(FlowLayout.LEFT);

				//realign attached components
				flowLayout.layoutContainer(container);
			}
		});

		centerJButton = new JButton("Center");
		add(centerJButton);
		centerJButton.addActionListener(new ActionListener()
		{
			@Override public void actionPerformed(ActionEvent e)
			{
				flowLayout.setAlignment(FlowLayout.CENTER);

				//realign attached components
				flowLayout.layoutContainer(container);
			}
		});

		rightJButton = new JButton("Right");
		add(rightJButton);
		rightJButton.addActionListener(new ActionListener()
		{
			@Override public void actionPerformed(ActionEvent e)
			{
				flowLayout.setAlignment(FlowLayout.RIGHT);

				//realign attached components
				flowLayout.layoutContainer(container);
			}
		});

		setVisible(true);
	}
}

class BorderLayoutFrame extends JFrame implements ActionListener
{
	private JButton[] buttons;
	private static final String[] buttonsNames = { "Hide North", "Hide South",
			"Hide East", "Hide West", "Hide Center" };
	private BorderLayout borderLayout;

	BorderLayoutFrame()
	{
		super("BorderLayout Demo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 200);

		borderLayout = new BorderLayout(5, 5); //5 pixels gaps
		buttons = new JButton[buttonsNames.length];

		for (int i = 0; i < buttonsNames.length; i++)
		{
			buttons[i] = new JButton(buttonsNames[i]);
			buttons[i].addActionListener(this);
		}

		add(buttons[0], BorderLayout.NORTH);
		add(buttons[1], BorderLayout.SOUTH);
				add(buttons[2], BorderLayout.EAST);
		add(buttons[3], BorderLayout.WEST);
		add(buttons[4], BorderLayout.CENTER);

		setVisible(true);
	}

	@Override public void actionPerformed(ActionEvent e)
	{
		for (JButton button : buttons)
		{
			if (e.getSource() == button)
						button.setVisible(false);
			else
				button.setVisible(true);
			}
		borderLayout.layoutContainer(getContentPane());
	}
}

class GridLayoutFrame extends JFrame implements ActionListener
{
	private JButton[] buttons;
	private static final String[] buttonsNames = { "One", "Two", "Three", "Four", "Five",
			"Six" };
	private Boolean toggle = true;
			private Container container;
	private GridLayout gridLayout1;
	private GridLayout gridLayout2;

	GridLayoutFrame()
	{
		super("GridLayout Demo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 200);

		gridLayout1 = new GridLayout(2, 3, 5, 5); //2 by 3; gaps of 5
		gridLayout2 = new GridLayout(3, 2); //3 by 2; no gaps
		container = getContentPane();
		setLayout(gridLayout1);
		buttons = new JButton[buttonsNames.length];

		for (int i = 0; i < buttonsNames.length; i++)
					{
			buttons[i] = new JButton(buttonsNames[i]);
				buttons[i].addActionListener(this);
			add(buttons[i]);
		}

				setVisible(true);
	}

	@Override public void actionPerformed(ActionEvent e)
	{
		if (toggle)
			container.setLayout(gridLayout2);
		else
			container.setLayout(gridLayout1);

		toggle = !toggle;
				container.validate(); //re-lay out container
	}
}

class MenuFrame extends JFrame implements ActionListener
{
	JRadioButtonMenuItem rb1,rb2,rb3;
	Container container;
	ButtonGroup group;

	MenuFrame()
	{
		super("JMenu Testing");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(500,500);

		container=getContentPane();

		JMenu formatMenu=new JMenu("Format");

		JMenu colorMenu=new JMenu("Color");

		formatMenu.add(colorMenu);

		JMenuBar bar=new JMenuBar();
		setJMenuBar(bar);
		bar.add(formatMenu);

		rb1=new JRadioButtonMenuItem("Black");
		rb1.addActionListener(this);
		rb2=new JRadioButtonMenuItem("Blue");
		rb2.addActionListener(this);
		rb3=new JRadioButtonMenuItem("Green");
		rb3.addActionListener(this);

		group=new ButtonGroup();
		group.add(rb1);
		group.add(rb2);
		group.add(rb3);

		colorMenu.add(rb1);
		colorMenu.add(rb2);
		colorMenu.add(rb3);


		setVisible(true);
	}

	@Override public void actionPerformed(ActionEvent e)
	{
		if(rb1.isSelected())
		{
			container.setBackground(Color.BLACK);
		}
		else if(rb2.isSelected())
		{
			container.setBackground(Color.BLUE);
		}
		else if(rb3.isSelected())
		{
			container.setBackground(Color.GREEN);
		}
	}
}
