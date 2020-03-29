/*
* The MIT License
*
* Copyright (c) 2019 Derick Felix
*
* Permission is hereby granted, free of charge, to any person obtaining a copy
* of this software and associated documentation files (the "Software"), to deal
* in the Software without restriction, including without limitation the rights
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the Software is
* furnished to do so, subject to the following conditions:
*
* The above copyright notice and this permission notice shall be included in all
* copies or substantial portions of the Software.
*
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
* SOFTWARE.
 */
package com.github.derickfelix.bankapplication.views.dialogs;

import com.github.derickfelix.bankapplication.utilities.MessageUtility;
import com.github.derickfelix.bankapplication.utilities.ViewUtility;
import com.github.derickfelix.bankapplication.views.users.MainForm;
import com.github.derickfelix.bankapplication.views.custom.StripedTableCellRenderer;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author derickfelix
 */
public class ExportDialog extends javax.swing.JDialog {

    private final List<String> columns;
    private final List<String[]> data;
    private final JFileChooser fileChooser;
    private final MainForm mainForm;
    
    public ExportDialog(MainForm mainForm, List<String> columns, List<String[]> data)
    {
        super(mainForm, true);

        this.columns = columns;
        this.data = data;
        this.fileChooser = new JFileChooser();
        this.mainForm = mainForm;

        initComponents();
        customSettings();
    }
    
    private void customSettings()
    {   
        cbSelectAll.setSelected(true);
        DefaultTableCellRenderer leftRenderer = new StripedTableCellRenderer(JLabel.LEFT);
        mainTable.setDefaultRenderer(Object.class, leftRenderer);
        mainTable.getTableHeader().setFont(new Font(Font.DIALOG, Font.PLAIN, 12));
        mainScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
         
        columns.forEach(column -> {
            Object[] row = new Object[2];
            row[0] = true;
            row[1] = column;
            ((DefaultTableModel) mainTable.getModel()).addRow(row);
        });
        
        toggleSelectAll();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        btnExport = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        paneFilePath = new javax.swing.JPanel();
        txtPath = new javax.swing.JTextField();
        btnBrowse = new javax.swing.JButton();
        mainScroll = new javax.swing.JScrollPane();
        mainTable = new javax.swing.JTable();
        cbSelectAll = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnExport.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        btnExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/print.png"))); // NOI18N
        btnExport.setText("Export");
        btnExport.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnExportActionPerformed(evt);
            }
        });

        btnClose.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCloseActionPerformed(evt);
            }
        });

        paneFilePath.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("File Path")));

        btnBrowse.setText("Browse...");
        btnBrowse.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnBrowseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneFilePathLayout = new javax.swing.GroupLayout(paneFilePath);
        paneFilePath.setLayout(paneFilePathLayout);
        paneFilePathLayout.setHorizontalGroup(
            paneFilePathLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneFilePathLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtPath)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBrowse)
                .addContainerGap())
        );
        paneFilePathLayout.setVerticalGroup(
            paneFilePathLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneFilePathLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneFilePathLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPath, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(btnBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );

        mainTable.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        mainTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "", "Column"
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.Boolean.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean []
            {
                false, false
            };

            public Class getColumnClass(int columnIndex)
            {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        mainTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        mainTable.setGridColor(new java.awt.Color(255, 255, 255));
        mainTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        mainTable.getTableHeader().setReorderingAllowed(false);
        mainTable.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseReleased(java.awt.event.MouseEvent evt)
            {
                mainTableMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                mainTableMouseClicked(evt);
            }
        });
        mainScroll.setViewportView(mainTable);
        if (mainTable.getColumnModel().getColumnCount() > 0)
        {
            mainTable.getColumnModel().getColumn(1).setMinWidth(200);
            mainTable.getColumnModel().getColumn(1).setPreferredWidth(200);
            mainTable.getColumnModel().getColumn(1).setMaxWidth(250);
        }

        cbSelectAll.setText("Select All");
        cbSelectAll.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cbSelectAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbSelectAll)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(paneFilePath, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mainScroll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnExport)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClose)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paneFilePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbSelectAll)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClose)
                    .addComponent(btnExport))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnExportActionPerformed
    {//GEN-HEADEREND:event_btnExportActionPerformed
        if (txtPath.getText().isEmpty()) {
            MessageUtility.warning(mainForm, "File path is empty!");
            return;
        }
        
        TableModel model = mainTable.getModel();
        boolean[] colStates = new boolean[model.getRowCount()];
        String[] colNames = new String[model.getRowCount()];

        for (int i = 0; i < model.getRowCount(); ++i) {
            colStates[i] = (boolean) model.getValueAt(i, 0);
            colNames[i] = (String) model.getValueAt(i, 1);
        }

        try {
            List<String[]> rows = new ArrayList<>();
            rows.add(colNames);
            
            data.forEach(row -> {
                rows.add(row);
            });
            
            
            ViewUtility.exportTableDataToFile(rows, colStates, txtPath.getText());
            MessageUtility.info(mainForm, "Data exported successfully!");
            txtPath.setText("");
        } catch (Exception e) {
            MessageUtility.error(mainForm, e);
        }
    }//GEN-LAST:event_btnExportActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnCloseActionPerformed
    {//GEN-HEADEREND:event_btnCloseActionPerformed
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void mainTableMouseReleased(java.awt.event.MouseEvent evt)//GEN-FIRST:event_mainTableMouseReleased
    {//GEN-HEADEREND:event_mainTableMouseReleased
        int row = mainTable.rowAtPoint(evt.getPoint());
        int col = mainTable.columnAtPoint(evt.getPoint());
        
        if (col == 0) {
            boolean value = (boolean) mainTable.getModel().getValueAt(row, col);
            mainTable.getModel().setValueAt(!value, row, col);
        }
    }//GEN-LAST:event_mainTableMouseReleased

    private void mainTableMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_mainTableMouseClicked
    {//GEN-HEADEREND:event_mainTableMouseClicked
    }//GEN-LAST:event_mainTableMouseClicked

    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnBrowseActionPerformed
    {//GEN-HEADEREND:event_btnBrowseActionPerformed
        selectFile();
    }//GEN-LAST:event_btnBrowseActionPerformed

    private void cbSelectAllActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cbSelectAllActionPerformed
    {//GEN-HEADEREND:event_cbSelectAllActionPerformed
        toggleSelectAll();
    }//GEN-LAST:event_cbSelectAllActionPerformed

    private void selectFile()
    {
        int returnValue = fileChooser.showOpenDialog(this);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            txtPath.setText(file.getAbsolutePath());
        }
    }
    
    private void toggleSelectAll()
    {
        boolean selected = cbSelectAll.isSelected();
        
        TableModel model = mainTable.getModel();
        
        for (int i = 0; i < model.getRowCount(); ++i) {
            model.setValueAt(selected, i, 0);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowse;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnExport;
    private javax.swing.JCheckBox cbSelectAll;
    private javax.swing.JScrollPane mainScroll;
    private javax.swing.JTable mainTable;
    private javax.swing.JPanel paneFilePath;
    private javax.swing.JTextField txtPath;
    // End of variables declaration//GEN-END:variables
}
