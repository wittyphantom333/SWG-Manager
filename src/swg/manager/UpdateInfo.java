/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swg.manager;

/**
 *
 * @author wittyphantom333
 */
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class UpdateInfo extends JFrame{

    private JEditorPane infoPane;
    private JScrollPane scp;
    private JButton ok;
    private JButton cancel;
    private JPanel pan1;
    private JPanel pan2;

    public UpdateInfo(String info) {
        initComponents();
        infoPane.setText(info);
    }

    private void initComponents() {

        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.setTitle("New Update Found");
        pan1 = new JPanel();
        pan1.setLayout(new BorderLayout());

        pan2 = new JPanel();
        pan2.setLayout(new FlowLayout());

        infoPane = new JEditorPane();
        infoPane.setContentType("text/html");

        scp = new JScrollPane();
        scp.setViewportView(infoPane);

        ok = new JButton("Update");
        ok.addActionListener( new ActionListener(){

            public void actionPerformed(ActionEvent e) {
                update();
            }
        });

        cancel = new JButton("Cancel");
        cancel.addActionListener( new ActionListener(){

            public void actionPerformed(ActionEvent e) {
                UpdateInfo.this.dispose();
            }
        });
        pan2.add(ok);
        pan2.add(cancel);
        pan1.add(pan2, BorderLayout.SOUTH);
        pan1.add(scp, BorderLayout.CENTER);
        this.add(pan1);
        pack();
        show();
        this.setAlwaysOnTop(true);
        this.setBounds(150, 150, 400, 300);
    }
    private void update()
    {
        String[] run = {"java","-jar","updater/update.jar"};
        try {
            Runtime.getRuntime().exec(run);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.exit(0);


    }

}

