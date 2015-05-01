/*
*   EuroCarbDB, a framework for carbohydrate bioinformatics
*
*   Copyright (c) 2006-2009, Eurocarb project, or third-party contributors as
*   indicated by the @author tags or express copyright attribution
*   statements applied by the authors.  
*
*   This copyrighted material is made available to anyone wishing to use, modify,
*   copy, or redistribute it subject to the terms and conditions of the GNU
*   Lesser General Public License, as published by the Free Software Foundation.
*   A copy of this license accompanies this distribution in the file LICENSE.txt.
*
*   This program is distributed in the hope that it will be useful,
*   but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
*   or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License
*   for more details.
*
*   Last commit: $Rev: 1210 $ by $Author: glycoslave $ on $Date:: 2009-06-12 #$  
*/

package org.eurocarbdb.application.glycanbuilder;

import javax.swing.*;

/**
   Dialog to specify a structure in a string format with a specified
   encoding. The supported encoding are specified by {@link
   GlycanParserFactory#getImportFormats}

   @author Alessio Ceroni (a.ceroni@imperial.ac.uk)
*/

public class ImportStructureDialog extends EscapeDialog implements java.awt.event.ActionListener {
    

    /** Creates new dialog */
    public ImportStructureDialog(java.awt.Frame parent) {
        super(parent, true);

        initComponents();
    fillComponents();
    setSelections();
    setTraversal();
    setActions();
    enableItems();

    // set location
    setLocationRelativeTo(parent);
    }

    private void fillComponents() {
    field_string_encoded.setText("");

    java.util.Map<String,String> formats = GlycanParserFactory.getImportFormats(true);
    field_string_format.setModel(new DefaultComboBoxModel(formats.keySet().toArray()));
    }

    private void setSelections() {
    }


    private void setTraversal() {
    CustomFocusTraversalPolicy tp = new CustomFocusTraversalPolicy();
    
    tp.addComponent(field_string_format);
    tp.addComponent(field_string_encoded);
    
    tp.addComponent(button_ok);
    tp.addComponent(button_cancel);

    this.setFocusTraversalPolicy(tp);

    getRootPane().setDefaultButton(button_ok);
    }

    private void setActions() {
    button_ok.addActionListener(this);
    button_cancel.addActionListener(this);
    }

    private void enableItems() {
    }

    /**
       Return <code>true</code> if the cancel button was pressed
     */
    public boolean isCanceled() {
    return return_status.equals("Cancel");
    }

    /**
       Return a string representing a structure encoded in the
       selected format
     */
    public String getStringEncoded() {
    return field_string_encoded.getText();
    }

    /**
       Return the format in which the structure was encoded
     */
    public String getStringFormat() {
    return (String)field_string_format.getSelectedItem();
    }
    
    public void actionPerformed(java.awt.event.ActionEvent e) {
    String action = e.getActionCommand();
    
    if (action == "OK") {
        return_status = "OK";
        closeDialog();
    }
    else if (action == "Cancel"){
        return_status = "Cancel";
        closeDialog();
    }
    }        

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        field_string_encoded = new javax.swing.JTextArea();
        button_ok = new javax.swing.JButton();
        button_cancel = new javax.swing.JButton();
        field_string_format = new javax.swing.JComboBox();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog();
            }
        });

        jLabel1.setText("String encoded");

        field_string_encoded.setColumns(20);
        field_string_encoded.setRows(10);
        jScrollPane1.setViewportView(field_string_encoded);

        button_ok.setText("OK");

        button_cancel.setText("Cancel");

        field_string_format.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "glycominds" }));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(jLabel1)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 200, Short.MAX_VALUE)
                                .add(field_string_format, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)))
                    .add(layout.createSequentialGroup()
                        .add(127, 127, 127)
                        .add(button_ok)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(button_cancel)))
                .addContainerGap())
        );

        layout.linkSize(new java.awt.Component[] {button_cancel, button_ok}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(field_string_format, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(17, 17, 17)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(button_cancel)
                    .add(button_ok))
                .addContainerGap())
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /** Closes the dialog */
    private void closeDialog() {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog
    
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_cancel;
    private javax.swing.JButton button_ok;
    private javax.swing.JTextArea field_string_encoded;
    private javax.swing.JComboBox field_string_format;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    
}
