package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterGUI extends JFrame {
    private JPanel wrapper;
    private JPanel jPanel_top;
    private JPanel jPanel_bottom;
    private JTextField textField_username;
    private JTextField textField_ad;
    private JPasswordField passwordField;
    private JPasswordField passwordField_again;
    private JLabel lbl_ad;
    private JLabel lbl_username;
    private JLabel lbl_pass;
    private JLabel lbl_passAgain;
    private JButton btn_register;

    public RegisterGUI() {
        add(wrapper);
        setSize(400, 500);
        setLocation(Helper.ScreenCoord("x", getSize()), Helper.ScreenCoord("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);

        btn_register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //veri çekme işlemi
                if (Helper.isFieldEmpty(textField_ad) || Helper.isFieldEmpty(textField_username) || Helper.isFieldEmpty(passwordField) || Helper.isFieldEmpty(passwordField_again)) {
                    Helper.showMessage("fill");
                } else {

                    if (String.valueOf(passwordField_again.getPassword()) == String.valueOf(passwordField.getPassword())) {
                        if (User.addStudent(textField_ad.getText(), textField_username.getText(), passwordField.getPassword().toString())) {
                            Helper.showMessage("done");
                        } else {
                            Helper.showMessage("error");
                        }
                    } else {
                        Helper.showMessage("error");
                    }

                }

            }
        });
    }
}
