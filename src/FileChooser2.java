//package com.mkyong.jfileChooser;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class FileChooser2 {

    public static void main(String[] args) {

        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Choose a directory to save your file: ");
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int returnValue = jfc.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            if (jfc.getSelectedFile().isFile()) {
                System.out.println("You selected the directory: " + jfc.getSelectedFile());
            }
        }

    }

}
