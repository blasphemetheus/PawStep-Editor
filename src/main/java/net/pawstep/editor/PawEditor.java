package net.pawstep.editor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollPane;
import javax.swing.tree.DefaultMutableTreeNode;

public class PawEditor extends JFrame implements ActionListener, ItemListener{
  JTextArea output;
  JScrollPane scrollPane;

 // private static PawEditor editor;

  private Logger logger = Logger.getLogger("PawEditor");
 // private JFrame window = new JFrame("PawStep Editor");


  public PawEditor() {
    super("PawEditor");
    this.initComponents();

    setResizable(true);
    setBounds(0, 0, 1280, 720); //1280, 720
    GridBagConstraints constraints = new GridBagConstraints();

    JPanel allpanels = new JPanel(new GridBagLayout());
    allpanels.setLayout(new BoxLayout(allpanels, BoxLayout.X_AXIS));

    JPanel panel1 = new JPanel(new GridBagLayout());
    constraints.fill = GridBagConstraints.HORIZONTAL;
    panel1.setBackground(Color.cyan);
    constraints.gridx=0;
    constraints.gridy=0;
    allpanels.add(panel1, constraints);

    JPanel panel2 = new JPanel(new GridBagLayout());
    constraints.fill = GridBagConstraints.HORIZONTAL;
    panel2.setBackground(Color.black);
    constraints.gridx=1;
    constraints.gridy=0;
    allpanels.add(panel2, constraints);

    JPanel panel3 = new JPanel(new GridBagLayout());
    constraints.fill = GridBagConstraints.HORIZONTAL;
    panel3.setBackground(Color.red);
    constraints.gridx=2;
    constraints.gridy=0;
    allpanels.add(panel3, constraints);

    JTree tree;

    DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");

    DefaultMutableTreeNode vegetableNode = new DefaultMutableTreeNode("Vegetables");
    vegetableNode.add(new DefaultMutableTreeNode("Capsicum"));
    vegetableNode.add(new DefaultMutableTreeNode("Carrot"));
    vegetableNode.add(new DefaultMutableTreeNode("Tomato"));
    vegetableNode.add(new DefaultMutableTreeNode("Potato"));

    DefaultMutableTreeNode fruitNode = new DefaultMutableTreeNode("Fruits");
    fruitNode.add(new DefaultMutableTreeNode("Banana"));
    fruitNode.add(new DefaultMutableTreeNode("Mango"));
    fruitNode.add(new DefaultMutableTreeNode("Apple"));
    fruitNode.add(new DefaultMutableTreeNode("Grapes"));
    fruitNode.add(new DefaultMutableTreeNode("Orange"));

    root.add(vegetableNode);
    root.add(fruitNode);

    tree = new JTree(root);

    JScrollPane scrollpane = new JScrollPane(tree);
    panel1.add(scrollpane);

    scrollpane.add(tree);

    constraints.anchor = GridBagConstraints.WEST;
    constraints.insets = new Insets(10, 10, 10, 10);

    add(allpanels);

  }

  // initializes all the components we're using
  private void initComponents() {
    JMenuBar topMenuBar = new JMenuBar();


  }
  public JMenuBar createMenuBar() {
    JMenuBar menuBar;
    JMenu menu;
    JMenu submenu;
    JMenuItem menuItem;
    JCheckBoxMenuItem checkMenuItem;

    //Create menu bar
    menuBar = new JMenuBar();

    // Lets Build A MenU!
    menu = new JMenu("File");
    // in case you want to display anything special when you save things
    menu.getAccessibleContext().setAccessibleDescription("A damned fine submenu amiright?");
    menuBar.add(menu);

    // lets make some submenu items. And lets give em hotkeys!
    menuItem = new JMenuItem("Saving the goshdarn changes", KeyEvent.VK_T);
    menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
    menuItem.getAccessibleContext().setAccessibleDescription("Saves");
    menuItem.addActionListener(this);
    menu.add(menuItem);

    // lets make a check box menu item
    menu.addSeparator();
    checkMenuItem = new JCheckBoxMenuItem("Invert Colors or somesuch");
    checkMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_0, KeyEvent.CTRL_MASK));
    menu.add(checkMenuItem);

    //lets make a submenu (settings)
    menuItem = new JMenuItem("Settings");
    menu.addSeparator();
    submenu = new JMenu("Settings");
    menuItem = new JMenuItem("A boolean");
    menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
    submenu.add(menuItem);

    menuItem = new JMenuItem("Another boolean");
    menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
    submenu.add(menuItem);

    menu.add(submenu);

    menuItem = new JMenuItem("Open");
    menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
    menu.add(menuItem);

    menu = new JMenu("View");
    menu.getAccessibleContext().setAccessibleDescription("Changes state in render somehow");

    menuItem = new JMenuItem("Boolean1");
    menu.add(menuItem);
    menuBar.add(menu);

    return menuBar;







  }

  //  public static PawEditor getEditor() {
//      return editor;
//  }
//
  public Logger getLogger() {
    return this.logger;
  }

  public static void main(String[] args) {

    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        // could instead create a ... createAndShowGUI(); that would do all the stuff
        // that happens in the constructor as well as the following
        PawEditor editor = new PawEditor();
        editor.setVisible(true);
        editor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        editor.setJMenuBar(editor.createMenuBar());

      }
    });
    // TODO Do initialization stuff.

//      editor = new PawEditor();

  }

  // handle when people do a thing (hotkey usually I think)
  @Override
  public void actionPerformed(ActionEvent e) {

    // presumably make a switch for the KeyEvents
    // you want to implement and make them do something
    //Suggestions:  call a saveAll Method,
    //              call a method mutating the boolean representing a state of the editor
    //              pop up a menu for Open



  }

  // handle state changes
  @Override
  public void itemStateChanged(ItemEvent e) {

  }
}
