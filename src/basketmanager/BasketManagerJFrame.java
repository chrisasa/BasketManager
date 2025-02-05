/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketmanager;

import database.DatabaseManager;
import database.FileDatabaseManagerPlayer;
import database.FileDatabaseManagerPlayerGame;
import database.FileDatabaseManagerMatch;
import database.FileDatabaseManagerSeason;
import database.ImportManager;
import database.ImportManager.ImportDialogType;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import objects.MatchRecord;
import objects.PlayerGameRecord;
import objects.PlayerRecord;
import objects.SeasonRecord;
import tools.GlobalVariables;

/**
 *
 * @author
 */
public class BasketManagerJFrame extends javax.swing.JFrame {

//    ExcelManagerInterface excelManager;
//    PlayerManagerInterface playerManager;
    /**
     * Creates new form BasketManagerJFrame
     */
    public BasketManagerJFrame() {
        initComponents();

//        excelManager = new ExcelManager();
        initApp();

        clearMainBodyContent();

        changeMainBodyContent(jPanel_Intro);
    }

    private void initApp() {
        initPlayersStoreFile();

        initMatchesStoreFile();

        initGamesStoreFile();

        initSeasonsStoreFile();

        initListeners();
    }
    
    private void initPlayersStoreFile() {
        File playersRaf = new File(GlobalVariables.pathPlayersRaf);
        if (!playersRaf.exists()) {
            DatabaseManager.createRafStoreFile(GlobalVariables.pathPlayersRaf);
        }
    }

    private void initMatchesStoreFile() {
        File playersRaf = new File(GlobalVariables.pathMatchesRaf);

        if (!playersRaf.exists()) {
            DatabaseManager.createRafStoreFile(GlobalVariables.pathMatchesRaf);
        }
    }

    private void initGamesStoreFile() {
        File playersRaf = new File(GlobalVariables.pathPlayersGamesRaf);

        if (!playersRaf.exists()) {
            DatabaseManager.createRafStoreFile(GlobalVariables.pathPlayersGamesRaf);
        }
    }

    private void initSeasonsStoreFile() {
        File playersRaf = new File(GlobalVariables.pathSeasonsRaf);

        if (!playersRaf.exists()) {
            DatabaseManager.createRafStoreFile(GlobalVariables.pathSeasonsRaf);
        }
    }

    private void initListeners() {
        jTable_PlayersList.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                JTable jTable = (JTable) me.getSource();
                Point p = me.getPoint();
                int row = jTable.rowAtPoint(p);
                // get the double click
                if (me.getClickCount() == 2) {
                    displayPlayerUpdate(jTable, row);
                }
            }

        });

        jTable_MatchesList.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                JTable jTable = (JTable) me.getSource();
                Point p = me.getPoint();
                int row = jTable.rowAtPoint(p);
                // get the double click
                if (me.getClickCount() == 2) {
                    displayMatchUpdate(jTable, row);
                }
            }

        });

        jTable_PlayerGamesList.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                JTable jTable = (JTable) me.getSource();
                Point p = me.getPoint();
                int row = jTable.rowAtPoint(p);
                // get the double click
                if (me.getClickCount() == 2) {
                    displayPlayerGameUpdate(jTable, row);
                }
            }

        });
    }

    private void changeMainBodyContent(JPanel newJPanel) {
        clearMainBodyContent();

        jPanel_MainBody.add(newJPanel, BorderLayout.PAGE_START);

        jPanel_MainBody.revalidate();
        jPanel_MainBody.repaint();
    }

    private void clearMainBodyContent() {
        jPanel_MainBody.removeAll();
        jPanel_MainBody.revalidate();
        jPanel_MainBody.repaint();
    }

    /**
     * This method is called from within the constructor to initialise the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_Intro = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jPanel_PlayerList = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_PlayersList = new javax.swing.JTable();
        jButton_DeletePlayer = new javax.swing.JButton();
        jLabel_PlayerDeleteMessage = new javax.swing.JLabel();
        jPanel_PlayerAdd = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTextField_PlayerFirstName = new javax.swing.JTextField();
        jTextField_PlayerLastName = new javax.swing.JTextField();
        jTextField_PlayerDoB = new javax.swing.JTextField();
        jTextField_PlayerPoB = new javax.swing.JTextField();
        jTextField_PlayerHeight = new javax.swing.JTextField();
        jTextField_PlayerWeight = new javax.swing.JTextField();
        jTextField_PlayerPosition = new javax.swing.JTextField();
        jTextField_PlayerJersey = new javax.swing.JTextField();
        jButton_AddPlayer = new javax.swing.JButton();
        jLabel_PlayerAddMessage = new javax.swing.JLabel();
        jPanel_PlayerUpdate = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jTextField_PlayerUpdateFirstName = new javax.swing.JTextField();
        jTextField_PlayerUpdateLastName = new javax.swing.JTextField();
        jTextField_PlayerUpdateDoB = new javax.swing.JTextField();
        jTextField_PlayerUpdatePoB = new javax.swing.JTextField();
        jTextField_PlayerUpdateHeight = new javax.swing.JTextField();
        jTextField_PlayerUpdateWeight = new javax.swing.JTextField();
        jTextField_PlayerUpdatePosition = new javax.swing.JTextField();
        jTextField_PlayerUpdateJersey = new javax.swing.JTextField();
        jButton_UpdatePlayer = new javax.swing.JButton();
        jButton_UpdatePlayerCancel = new javax.swing.JButton();
        jLabel_PlayerUpdateMessage = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel_PlayerUpdateId = new javax.swing.JLabel();
        jPanel_PlayerGameList = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable_PlayerGamesList = new javax.swing.JTable();
        jButton_DeletePlayerGame = new javax.swing.JButton();
        jLabel_PlayerGameDeleteMessage = new javax.swing.JLabel();
        jPanel_PlayerGameAdd = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jComboBox_PlayerGameSeasonName = new javax.swing.JComboBox<>();
        jComboBox_PlayerGamePlayerName = new javax.swing.JComboBox<>();
        jTextField_PlayerGameFoulsCommitted = new javax.swing.JTextField();
        jTextField_PlayerGameFoulsConceded = new javax.swing.JTextField();
        jTextField_PlayerGameAssists = new javax.swing.JTextField();
        jTextField_PlayerGameRebounds = new javax.swing.JTextField();
        jTextField_PlayerGameSteals = new javax.swing.JTextField();
        jTextField_PlayerGameBlocks = new javax.swing.JTextField();
        jCheckBox_PlayerGameHomeGame = new javax.swing.JCheckBox();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jTextField_PlayerGameAwayTeamName = new javax.swing.JTextField();
        jTextField_PlayerGamePointsScored = new javax.swing.JTextField();
        jTextField_PlayerGameLocation = new javax.swing.JTextField();
        jSpinner_PlayerGameDate = new javax.swing.JSpinner();
        jLabel_PlayerGameAddMessage = new javax.swing.JLabel();
        jButton_AddPlayerGame = new javax.swing.JButton();
        jPanel_PlayerGameUpdate = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel_PlayerGameUpdateGameId = new javax.swing.JLabel();
        jLabel_PlayerGameUpdatePlayerId = new javax.swing.JLabel();
        jLabel_PlayerGameUpdatePlayerName = new javax.swing.JLabel();
        jTextField_PlayerGameUpdateFoulsCommitted = new javax.swing.JTextField();
        jTextField_PlayerGameUpdateFoulsConceded = new javax.swing.JTextField();
        jTextField_PlayerGameUpdateAssists = new javax.swing.JTextField();
        jTextField_PlayerGameUpdateRebounds = new javax.swing.JTextField();
        jTextField_PlayerGameUpdateSteals = new javax.swing.JTextField();
        jTextField_PlayerGameUpdateBlocks = new javax.swing.JTextField();
        jCheckBox_PlayerGameUpdateHomeGame = new javax.swing.JCheckBox();
        jTextField_PlayerGameUpdateAwayTeamName = new javax.swing.JTextField();
        jTextField_PlayerGameUpdatePointsScored = new javax.swing.JTextField();
        jTextField_PlayerGameUpdateLocation = new javax.swing.JTextField();
        jSpinner_PlayerGameUpdateDate = new javax.swing.JSpinner();
        jLabel_PlayerGameUpdateMessage = new javax.swing.JLabel();
        jButton_UpdatePlayerGame = new javax.swing.JButton();
        jButton_UpdatePlayerGameCancel = new javax.swing.JButton();
        jLabel67 = new javax.swing.JLabel();
        jLabel_PlayerGameUpdateSeasonId = new javax.swing.JLabel();
        jLabel_PlayerGameUpdateSeasonName = new javax.swing.JLabel();
        jPanel_MatchList = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_MatchesList = new javax.swing.JTable();
        jButton_DeleteMatch = new javax.swing.JButton();
        jLabel_MatchDeleteMessage = new javax.swing.JLabel();
        jPanel_MatchAdd = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField_MatchOpponent = new javax.swing.JTextField();
        jTextField_MatchFoulsCommitted = new javax.swing.JTextField();
        jTextField_MatchFoulsConceded = new javax.swing.JTextField();
        jTextField_MatchAssists = new javax.swing.JTextField();
        jTextField_MatchRebounds = new javax.swing.JTextField();
        jTextField_MatchSteals = new javax.swing.JTextField();
        jTextField_MatchBlocks = new javax.swing.JTextField();
        jTextField_MatchPointsScored = new javax.swing.JTextField();
        jTextField_MatchPointsConceded = new javax.swing.JTextField();
        jTextField_MatchLocation = new javax.swing.JTextField();
        jCheckBox_MatchHomeGame = new javax.swing.JCheckBox();
        jSpinner_MatchDate = new javax.swing.JSpinner();
        jLabel_MatchAddMessage = new javax.swing.JLabel();
        jButton_AddMatch = new javax.swing.JButton();
        jComboBox_MatchSeasonName = new javax.swing.JComboBox<>();
        jPanel_MatchUpdate = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel_MatchUpdateId = new javax.swing.JLabel();
        jTextField_MatchUpdateOpponent = new javax.swing.JTextField();
        jSpinner_MatchUpdateDate = new javax.swing.JSpinner();
        jTextField_MatchUpdateFoulsCommitted = new javax.swing.JTextField();
        jTextField_MatchUpdateFoulsConceded = new javax.swing.JTextField();
        jTextField_MatchUpdateAssists = new javax.swing.JTextField();
        jTextField_MatchUpdateRebounds = new javax.swing.JTextField();
        jTextField_MatchUpdateSteals = new javax.swing.JTextField();
        jTextField_MatchUpdateBlocks = new javax.swing.JTextField();
        jCheckBox_MatchUpdateHomeGame = new javax.swing.JCheckBox();
        jTextField_MatchUpdatePointsScored = new javax.swing.JTextField();
        jTextField_MatchUpdatePointsConceded = new javax.swing.JTextField();
        jTextField_MatchUpdateLocation = new javax.swing.JTextField();
        jLabel_MatchUpdateMessage = new javax.swing.JLabel();
        jButton_UpdateMatch = new javax.swing.JButton();
        jButton_UpdateMatchCancel = new javax.swing.JButton();
        jLabel52 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel_MatchUpdateSeasonId = new javax.swing.JLabel();
        jLabel_MatchUpdateSeasonName = new javax.swing.JLabel();
        jPanel_SeasonList = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList_SeasonList = new javax.swing.JList<>();
        jPanel_SeasonAdd = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel65 = new javax.swing.JLabel();
        jTextField_SeasonName = new javax.swing.JTextField();
        jButton_AddPlayer1 = new javax.swing.JButton();
        jLabel_SeasonAddMessage = new javax.swing.JLabel();
        jFileChooser_ImportExcel = new javax.swing.JFileChooser();
        jPanel_StatsSingleSeasonPlayer = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jButton_ShowStatsSingleSeasonPlayer = new javax.swing.JButton();
        jComboBox_StatsSingleSeasonPlayerPlayers = new javax.swing.JComboBox<>();
        jComboBox_StatsSingleSeasonPlayerSeasons = new javax.swing.JComboBox<>();
        jLabel_StatsSingleSeasonPlayerMessage = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel_StatsSingleSeasonPlayerAverPointsScored = new javax.swing.JLabel();
        jLabel_StatsSingleSeasonPlayerAverRebounds = new javax.swing.JLabel();
        jLabel_StatsSingleSeasonPlayerAverAssists = new javax.swing.JLabel();
        jPanel_StatsSingleSeasonTeam = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel76 = new javax.swing.JLabel();
        jButton_ShowStatsSingleSeasonTeam = new javax.swing.JButton();
        jComboBox_StatsSingleSeasonTeamSeasons = new javax.swing.JComboBox<>();
        jLabel_StatsSingleSeasonTeamMessage = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel_StatsSingleSeasonTeamAverPointsScored = new javax.swing.JLabel();
        jLabel_StatsSingleSeasonTeamAverPointsConceded = new javax.swing.JLabel();
        jPanel_StatsMultipleSeasonsPlayer = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        jButton_ShowStatsMultipleSeasonsPlayer = new javax.swing.JButton();
        jComboBox_StatsMultipleSeasonsPlayerPlayers = new javax.swing.JComboBox<>();
        jLabel_StatsMultipleSeasonsPlayerMessage = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel_StatsMultipleSeasonsPlayerAverPointsScored = new javax.swing.JLabel();
        jLabel_StatsMultipleSeasonsPlayerAverRebounds = new javax.swing.JLabel();
        jLabel_StatsMultipleSeasonsPlayerAverAssists = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jList_StatsMultipleSeasonsPlayerSeasons = new javax.swing.JList<>();
        jPanel_StatsMultipleSeasonsTeam = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jButton_ShowStatsMultipleSeasonsTeam = new javax.swing.JButton();
        jLabel_StatsMultipleSeasonsTeamMessage = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel_StatsMultipleSeasonsTeamAverPointsScored = new javax.swing.JLabel();
        jLabel_StatsMultipleSeasonsTeamAverPointsConceded = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jList_StatsMultipleSeasonsTeamSeasons = new javax.swing.JList<>();
        jPanel_Main = new javax.swing.JPanel();
        jPanel_MainBody = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu_File = new javax.swing.JMenu();
        jMenuItem_FileImportPlayers = new javax.swing.JMenuItem();
        jMenuItem_FileImportMatches = new javax.swing.JMenuItem();
        jMenuItem_FileImportPlayersGames = new javax.swing.JMenuItem();
        jMenuItem_FileExit = new javax.swing.JMenuItem();
        jMenu_Player = new javax.swing.JMenu();
        jMenuItem_PlayerAdd = new javax.swing.JMenuItem();
        jMenuItem_PlayerList = new javax.swing.JMenuItem();
        jMenuItem_PlayerAddGame = new javax.swing.JMenuItem();
        jMenuItem_PlayerGameList = new javax.swing.JMenuItem();
        jMenu_MatchData = new javax.swing.JMenu();
        jMenuItem_MatchAddNew = new javax.swing.JMenuItem();
        jMenuItem_MatchList = new javax.swing.JMenuItem();
        jMenu_Season = new javax.swing.JMenu();
        jMenuItem_SeasonAddSeason = new javax.swing.JMenuItem();
        jMenuItem_SeasonList = new javax.swing.JMenuItem();
        jMenu_Statictis = new javax.swing.JMenu();
        jMenu_SingleSeason = new javax.swing.JMenu();
        jMenuItem_SingleSeasonPlayer = new javax.swing.JMenuItem();
        jMenuItem_SingleSeasonTeam = new javax.swing.JMenuItem();
        jMenu_MultipleSeasons = new javax.swing.JMenu();
        jMenuItem_MultipleSeasonPlayer = new javax.swing.JMenuItem();
        jMenuItem_MultipleSeasonTeam = new javax.swing.JMenuItem();

        jPanel_Intro.setPreferredSize(new java.awt.Dimension(970, 570));
        jPanel_Intro.setLayout(new java.awt.BorderLayout());

        jLabel30.setFont(new java.awt.Font("Lucida Handwriting", 0, 36)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Basket Manager v.1.0");
        jLabel30.setPreferredSize(new java.awt.Dimension(150, 16));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, 958, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel_Intro.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel_PlayerList.setBorder(javax.swing.BorderFactory.createTitledBorder("List of Players"));
        jPanel_PlayerList.setLayout(new java.awt.BorderLayout());

        jTable_PlayersList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "First Name", "Last Name", "DoB", "PoB", "Height", "Weight", "Position", "Jersey"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_PlayersList.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable_PlayersList);
        jTable_PlayersList.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jButton_DeletePlayer.setText("Delete");
        jButton_DeletePlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DeletePlayerActionPerformed(evt);
            }
        });

        jLabel_PlayerDeleteMessage.setText(" ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 946, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel_PlayerDeleteMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_DeletePlayer)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_DeletePlayer)
                    .addComponent(jLabel_PlayerDeleteMessage))
                .addContainerGap())
        );

        jPanel_PlayerList.add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel_PlayerAdd.setBorder(javax.swing.BorderFactory.createTitledBorder("Add Player"));
        jPanel_PlayerAdd.setPreferredSize(new java.awt.Dimension(970, 570));
        jPanel_PlayerAdd.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("First Name");
        jLabel1.setPreferredSize(new java.awt.Dimension(150, 16));

        jLabel10.setText("Last Name");
        jLabel10.setPreferredSize(new java.awt.Dimension(150, 16));

        jLabel11.setText("DoB");
        jLabel11.setPreferredSize(new java.awt.Dimension(150, 16));

        jLabel12.setText("PoB");
        jLabel12.setPreferredSize(new java.awt.Dimension(150, 16));

        jLabel16.setText("Height");
        jLabel16.setPreferredSize(new java.awt.Dimension(150, 16));

        jLabel17.setText("Weight");
        jLabel17.setPreferredSize(new java.awt.Dimension(150, 16));

        jLabel18.setText("Position");
        jLabel18.setPreferredSize(new java.awt.Dimension(150, 16));

        jLabel19.setText("Jersey");
        jLabel19.setPreferredSize(new java.awt.Dimension(150, 16));

        jTextField_PlayerFirstName.setPreferredSize(new java.awt.Dimension(200, 28));

        jTextField_PlayerLastName.setPreferredSize(new java.awt.Dimension(200, 28));

        jTextField_PlayerDoB.setPreferredSize(new java.awt.Dimension(200, 28));

        jTextField_PlayerPoB.setPreferredSize(new java.awt.Dimension(200, 28));

        jTextField_PlayerHeight.setPreferredSize(new java.awt.Dimension(200, 28));

        jTextField_PlayerWeight.setPreferredSize(new java.awt.Dimension(200, 28));

        jTextField_PlayerPosition.setPreferredSize(new java.awt.Dimension(200, 28));

        jTextField_PlayerJersey.setPreferredSize(new java.awt.Dimension(200, 28));

        jButton_AddPlayer.setText("Add");
        jButton_AddPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AddPlayerActionPerformed(evt);
            }
        });

        jLabel_PlayerAddMessage.setForeground(java.awt.Color.red);
        jLabel_PlayerAddMessage.setText(" ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_PlayerAddMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_PlayerFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_PlayerLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_PlayerDoB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_PlayerPoB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_PlayerHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_PlayerWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_PlayerPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_PlayerJersey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton_AddPlayer))
                        .addGap(0, 584, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_PlayerFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_PlayerLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_PlayerDoB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_PlayerPoB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_PlayerHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_PlayerWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_PlayerPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_PlayerJersey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel_PlayerAddMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                .addComponent(jButton_AddPlayer)
                .addContainerGap())
        );

        jPanel_PlayerAdd.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel_PlayerUpdate.setBorder(javax.swing.BorderFactory.createTitledBorder("Update Player"));
        jPanel_PlayerUpdate.setPreferredSize(new java.awt.Dimension(970, 570));
        jPanel_PlayerUpdate.setLayout(new java.awt.BorderLayout());

        jLabel32.setText("First Name");
        jLabel32.setPreferredSize(new java.awt.Dimension(150, 16));

        jLabel33.setText("Last Name");
        jLabel33.setPreferredSize(new java.awt.Dimension(150, 16));

        jLabel34.setText("DoB");
        jLabel34.setPreferredSize(new java.awt.Dimension(150, 16));

        jLabel35.setText("PoB");
        jLabel35.setPreferredSize(new java.awt.Dimension(150, 16));

        jLabel36.setText("Height");
        jLabel36.setPreferredSize(new java.awt.Dimension(150, 16));

        jLabel37.setText("Weight");
        jLabel37.setPreferredSize(new java.awt.Dimension(150, 16));

        jLabel38.setText("Position");
        jLabel38.setPreferredSize(new java.awt.Dimension(150, 16));

        jLabel39.setText("Jersey");
        jLabel39.setPreferredSize(new java.awt.Dimension(150, 16));

        jTextField_PlayerUpdateFirstName.setPreferredSize(new java.awt.Dimension(200, 28));

        jTextField_PlayerUpdateLastName.setPreferredSize(new java.awt.Dimension(200, 28));

        jTextField_PlayerUpdateDoB.setPreferredSize(new java.awt.Dimension(200, 28));

        jTextField_PlayerUpdatePoB.setPreferredSize(new java.awt.Dimension(200, 28));

        jTextField_PlayerUpdateHeight.setPreferredSize(new java.awt.Dimension(200, 28));

        jTextField_PlayerUpdateWeight.setPreferredSize(new java.awt.Dimension(200, 28));

        jTextField_PlayerUpdatePosition.setPreferredSize(new java.awt.Dimension(200, 28));

        jTextField_PlayerUpdateJersey.setPreferredSize(new java.awt.Dimension(200, 28));

        jButton_UpdatePlayer.setText("Update");
        jButton_UpdatePlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_UpdatePlayerActionPerformed(evt);
            }
        });

        jButton_UpdatePlayerCancel.setText("Cancel");
        jButton_UpdatePlayerCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_UpdatePlayerCancelActionPerformed(evt);
            }
        });

        jLabel_PlayerUpdateMessage.setForeground(java.awt.Color.red);
        jLabel_PlayerUpdateMessage.setText(" ");

        jLabel40.setText("Player ID");

        jLabel_PlayerUpdateId.setText(" ");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_PlayerUpdateMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jButton_UpdatePlayer)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_UpdatePlayerCancel))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_PlayerUpdateLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_PlayerUpdateDoB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_PlayerUpdatePoB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_PlayerUpdateHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_PlayerUpdateWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_PlayerUpdatePosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_PlayerUpdateJersey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField_PlayerUpdateFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel_PlayerUpdateId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 584, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(jLabel_PlayerUpdateId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_PlayerUpdateFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_PlayerUpdateLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_PlayerUpdateDoB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_PlayerUpdatePoB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_PlayerUpdateHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_PlayerUpdateWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_PlayerUpdatePosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_PlayerUpdateJersey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addComponent(jLabel_PlayerUpdateMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_UpdatePlayer)
                    .addComponent(jButton_UpdatePlayerCancel))
                .addContainerGap())
        );

        jPanel_PlayerUpdate.add(jPanel7, java.awt.BorderLayout.CENTER);

        jPanel_PlayerGameList.setBorder(javax.swing.BorderFactory.createTitledBorder("List of Players Games"));
        jPanel_PlayerGameList.setLayout(new java.awt.BorderLayout());

        jTable_PlayerGamesList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Season Name", "Player Name", "Fouls Commited", "Fouls Conceded", "Assists", "Rebounds", "Steals", "Blocks", "Home Game", "Away Team", "Points Scored", "Location", "Game Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_PlayerGamesList.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jTable_PlayerGamesList);
        jTable_PlayerGamesList.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jButton_DeletePlayerGame.setText("Delete Game");
        jButton_DeletePlayerGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DeletePlayerGameActionPerformed(evt);
            }
        });

        jLabel_PlayerGameDeleteMessage.setText(" ");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 958, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel_PlayerGameDeleteMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_DeletePlayerGame)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_DeletePlayerGame)
                    .addComponent(jLabel_PlayerGameDeleteMessage))
                .addContainerGap())
        );

        jPanel_PlayerGameList.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel_PlayerGameAdd.setBorder(javax.swing.BorderFactory.createTitledBorder("Add Game"));
        jPanel_PlayerGameAdd.setPreferredSize(new java.awt.Dimension(970, 570));
        jPanel_PlayerGameAdd.setLayout(new java.awt.BorderLayout());

        jLabel66.setText("Season Name");
        jLabel66.setPreferredSize(new java.awt.Dimension(150, 16));

        jLabel31.setText("Player Name");
        jLabel31.setPreferredSize(new java.awt.Dimension(150, 16));

        jLabel20.setText("Fouls Committed");
        jLabel20.setPreferredSize(new java.awt.Dimension(150, 16));

        jLabel21.setText("Fouls Conceded");
        jLabel21.setPreferredSize(new java.awt.Dimension(150, 16));

        jLabel22.setText("Assists");
        jLabel22.setPreferredSize(new java.awt.Dimension(150, 16));

        jLabel23.setText("Rebounds");
        jLabel23.setPreferredSize(new java.awt.Dimension(150, 16));

        jLabel24.setText("Steals");
        jLabel24.setPreferredSize(new java.awt.Dimension(150, 16));

        jLabel25.setText("Blocks");
        jLabel25.setPreferredSize(new java.awt.Dimension(150, 16));

        jTextField_PlayerGameFoulsCommitted.setPreferredSize(new java.awt.Dimension(200, 28));

        jTextField_PlayerGameFoulsConceded.setPreferredSize(new java.awt.Dimension(200, 28));

        jTextField_PlayerGameAssists.setPreferredSize(new java.awt.Dimension(200, 28));

        jTextField_PlayerGameRebounds.setPreferredSize(new java.awt.Dimension(200, 28));

        jTextField_PlayerGameSteals.setPreferredSize(new java.awt.Dimension(200, 28));

        jTextField_PlayerGameBlocks.setPreferredSize(new java.awt.Dimension(200, 28));

        jCheckBox_PlayerGameHomeGame.setText("Home Game");

        jLabel26.setText("Away Team");
        jLabel26.setPreferredSize(new java.awt.Dimension(150, 16));

        jLabel27.setText("Points Scored");
        jLabel27.setPreferredSize(new java.awt.Dimension(150, 16));

        jLabel28.setText("Location/City");
        jLabel28.setPreferredSize(new java.awt.Dimension(150, 16));

        jLabel29.setText("Game Date");
        jLabel29.setPreferredSize(new java.awt.Dimension(150, 16));

        jTextField_PlayerGameAwayTeamName.setPreferredSize(new java.awt.Dimension(200, 28));

        jTextField_PlayerGamePointsScored.setPreferredSize(new java.awt.Dimension(200, 28));

        jTextField_PlayerGameLocation.setPreferredSize(new java.awt.Dimension(200, 28));

        jSpinner_PlayerGameDate.setModel(new javax.swing.SpinnerDateModel());

        jLabel_PlayerGameAddMessage.setText(" ");

        jButton_AddPlayerGame.setText("Add");
        jButton_AddPlayerGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AddPlayerGameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_PlayerGameAddMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jComboBox_PlayerGameSeasonName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField_PlayerGameSteals, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButton_AddPlayerGame)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jCheckBox_PlayerGameHomeGame)
                                            .addComponent(jTextField_PlayerGameBlocks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jComboBox_PlayerGamePlayerName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField_PlayerGameFoulsCommitted, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField_PlayerGameFoulsConceded, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField_PlayerGameAssists, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField_PlayerGameRebounds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField_PlayerGamePointsScored, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField_PlayerGameLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jSpinner_PlayerGameDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_PlayerGameAwayTeamName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 204, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox_PlayerGameSeasonName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox_PlayerGamePlayerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_PlayerGameFoulsCommitted, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_PlayerGamePointsScored, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_PlayerGameLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner_PlayerGameDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_PlayerGameFoulsConceded, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_PlayerGameAssists, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_PlayerGameRebounds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_PlayerGameSteals, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_PlayerGameBlocks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox_PlayerGameHomeGame)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_PlayerGameAwayTeamName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel_PlayerGameAddMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addComponent(jButton_AddPlayerGame)
                .addContainerGap())
        );

        jPanel_PlayerGameAdd.add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel_PlayerGameUpdate.setBorder(javax.swing.BorderFactory.createTitledBorder("Update Player Game"));
        jPanel_PlayerGameUpdate.setPreferredSize(new java.awt.Dimension(970, 570));
        jPanel_PlayerGameUpdate.setLayout(new java.awt.BorderLayout());

        jLabel64.setText("Player Game Id");
        jLabel64.setPreferredSize(new java.awt.Dimension(150, 16));

        jLabel63.setText("Player Id & Name");
        jLabel63.setPreferredSize(new java.awt.Dimension(150, 16));

        jLabel53.setText("Fouls Committed");
        jLabel53.setPreferredSize(new java.awt.Dimension(150, 16));

        jLabel54.setText("Fouls Conceded");
        jLabel54.setPreferredSize(new java.awt.Dimension(150, 16));

        jLabel55.setText("Assists");
        jLabel55.setPreferredSize(new java.awt.Dimension(150, 16));

        jLabel56.setText("Rebounds");
        jLabel56.setPreferredSize(new java.awt.Dimension(150, 16));

        jLabel57.setText("Steals");
        jLabel57.setPreferredSize(new java.awt.Dimension(150, 16));

        jLabel58.setText("Blocks");
        jLabel58.setPreferredSize(new java.awt.Dimension(150, 16));

        jLabel59.setText("Away Team");
        jLabel59.setPreferredSize(new java.awt.Dimension(150, 16));

        jLabel60.setText("Points Scored");
        jLabel60.setPreferredSize(new java.awt.Dimension(150, 16));

        jLabel61.setText("Location/City");
        jLabel61.setPreferredSize(new java.awt.Dimension(150, 16));

        jLabel62.setText("Game Date");
        jLabel62.setPreferredSize(new java.awt.Dimension(150, 16));

        jLabel_PlayerGameUpdateGameId.setText(" ");
        jLabel_PlayerGameUpdateGameId.setPreferredSize(new java.awt.Dimension(150, 16));

        jLabel_PlayerGameUpdatePlayerId.setText(" ");

        jLabel_PlayerGameUpdatePlayerName.setText(" ");
        jLabel_PlayerGameUpdatePlayerName.setPreferredSize(new java.awt.Dimension(150, 16));

        jTextField_PlayerGameUpdateFoulsCommitted.setPreferredSize(new java.awt.Dimension(200, 28));

        jTextField_PlayerGameUpdateFoulsConceded.setPreferredSize(new java.awt.Dimension(200, 28));

        jTextField_PlayerGameUpdateAssists.setPreferredSize(new java.awt.Dimension(200, 28));

        jTextField_PlayerGameUpdateRebounds.setPreferredSize(new java.awt.Dimension(200, 28));

        jTextField_PlayerGameUpdateSteals.setPreferredSize(new java.awt.Dimension(200, 28));

        jTextField_PlayerGameUpdateBlocks.setPreferredSize(new java.awt.Dimension(200, 28));

        jCheckBox_PlayerGameUpdateHomeGame.setText("Home Game");

        jTextField_PlayerGameUpdateAwayTeamName.setPreferredSize(new java.awt.Dimension(200, 28));

        jTextField_PlayerGameUpdatePointsScored.setPreferredSize(new java.awt.Dimension(200, 28));

        jTextField_PlayerGameUpdateLocation.setPreferredSize(new java.awt.Dimension(200, 28));

        jSpinner_PlayerGameUpdateDate.setModel(new javax.swing.SpinnerDateModel());

        jLabel_PlayerGameUpdateMessage.setText(" ");

        jButton_UpdatePlayerGame.setText("Update");
        jButton_UpdatePlayerGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_UpdatePlayerGameActionPerformed(evt);
            }
        });

        jButton_UpdatePlayerGameCancel.setText("Cancel");
        jButton_UpdatePlayerGameCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_UpdatePlayerGameCancelActionPerformed(evt);
            }
        });

        jLabel67.setText("Season Id & Name");
        jLabel67.setPreferredSize(new java.awt.Dimension(150, 16));

        jLabel_PlayerGameUpdateSeasonId.setText(" ");

        jLabel_PlayerGameUpdateSeasonName.setText(" ");
        jLabel_PlayerGameUpdateSeasonName.setPreferredSize(new java.awt.Dimension(150, 16));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_PlayerGameUpdateMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel_PlayerGameUpdatePlayerId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel_PlayerGameUpdatePlayerName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField_PlayerGameUpdateSteals, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField_PlayerGameUpdateAwayTeamName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jButton_UpdatePlayerGame)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton_UpdatePlayerGameCancel))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jCheckBox_PlayerGameUpdateHomeGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jTextField_PlayerGameUpdateBlocks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField_PlayerGameUpdateFoulsCommitted, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField_PlayerGameUpdateFoulsConceded, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField_PlayerGameUpdateAssists, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField_PlayerGameUpdateRebounds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel_PlayerGameUpdateGameId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField_PlayerGameUpdatePointsScored, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField_PlayerGameUpdateLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jSpinner_PlayerGameUpdateDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel_PlayerGameUpdateSeasonId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel_PlayerGameUpdateSeasonName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 216, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_PlayerGameUpdateGameId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_PlayerGameUpdateSeasonName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_PlayerGameUpdateSeasonId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_PlayerGameUpdatePlayerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_PlayerGameUpdatePlayerId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_PlayerGameUpdateFoulsCommitted, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_PlayerGameUpdateFoulsConceded, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_PlayerGameUpdateAssists, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_PlayerGameUpdatePointsScored, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_PlayerGameUpdateLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner_PlayerGameUpdateDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(16, 16, 16)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_PlayerGameUpdateRebounds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_PlayerGameUpdateSteals, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_PlayerGameUpdateBlocks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox_PlayerGameUpdateHomeGame)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_PlayerGameUpdateAwayTeamName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(104, 104, 104)
                .addComponent(jLabel_PlayerGameUpdateMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_UpdatePlayerGame)
                    .addComponent(jButton_UpdatePlayerGameCancel))
                .addContainerGap())
        );

        jPanel_PlayerGameUpdate.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel_MatchList.setBorder(javax.swing.BorderFactory.createTitledBorder("List of Matches"));
        jPanel_MatchList.setLayout(new java.awt.BorderLayout());

        jTable_MatchesList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Season Name", "Opponent", "Date", "Fouls Commited", "Fouls Conceded", "Assists", "Rebounds", "Steals", "Blocks", "Home Game", "Points Scored", "Points Conceded", "Location"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_MatchesList.setColumnSelectionAllowed(true);
        jTable_MatchesList.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTable_MatchesList);
        jTable_MatchesList.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jButton_DeleteMatch.setText("Delete");
        jButton_DeleteMatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DeleteMatchActionPerformed(evt);
            }
        });

        jLabel_MatchDeleteMessage.setText(" ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 946, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel_MatchDeleteMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_DeleteMatch)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_DeleteMatch)
                    .addComponent(jLabel_MatchDeleteMessage))
                .addContainerGap())
        );

        jPanel_MatchList.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel_MatchAdd.setBorder(javax.swing.BorderFactory.createTitledBorder("Add Match Data"));

        jLabel68.setText("Season Name");

        jLabel2.setText("Opponent");

        jLabel3.setText("Date");

        jLabel4.setText("Fouls Commited");

        jLabel5.setText("Fouls Conceded");

        jLabel6.setText("Assists");

        jLabel7.setText("Rebounds");

        jLabel8.setText("Steals");

        jLabel9.setText("Blocks");

        jLabel13.setText("Points Scored");

        jLabel14.setText("Points Conceded");

        jLabel15.setText("Location (City/Town)");

        jCheckBox_MatchHomeGame.setText("Home Game");

        jSpinner_MatchDate.setModel(new javax.swing.SpinnerDateModel());

        jLabel_MatchAddMessage.setText(" ");

        jButton_AddMatch.setText("Add");
        jButton_AddMatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AddMatchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_MatchAddLayout = new javax.swing.GroupLayout(jPanel_MatchAdd);
        jPanel_MatchAdd.setLayout(jPanel_MatchAddLayout);
        jPanel_MatchAddLayout.setHorizontalGroup(
            jPanel_MatchAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_MatchAddLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_MatchAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_MatchAddMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel_MatchAddLayout.createSequentialGroup()
                        .addGroup(jPanel_MatchAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_AddMatch)
                            .addGroup(jPanel_MatchAddLayout.createSequentialGroup()
                                .addGroup(jPanel_MatchAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_MatchAddLayout.createSequentialGroup()
                                        .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jComboBox_MatchSeasonName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_MatchAddLayout.createSequentialGroup()
                                        .addGroup(jPanel_MatchAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel_MatchAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextField_MatchOpponent)
                                            .addComponent(jTextField_MatchFoulsCommitted)
                                            .addComponent(jTextField_MatchFoulsConceded)
                                            .addComponent(jTextField_MatchAssists)
                                            .addComponent(jTextField_MatchRebounds)
                                            .addComponent(jTextField_MatchSteals)
                                            .addComponent(jTextField_MatchBlocks)
                                            .addComponent(jTextField_MatchPointsScored)
                                            .addComponent(jCheckBox_MatchHomeGame, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                            .addComponent(jSpinner_MatchDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel_MatchAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel_MatchAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField_MatchPointsConceded, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(jTextField_MatchLocation))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel_MatchAddLayout.setVerticalGroup(
            jPanel_MatchAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_MatchAddLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_MatchAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_MatchAddLayout.createSequentialGroup()
                        .addGroup(jPanel_MatchAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jTextField_MatchPointsConceded, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel_MatchAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jTextField_MatchLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel_MatchAddLayout.createSequentialGroup()
                        .addGroup(jPanel_MatchAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel68)
                            .addComponent(jComboBox_MatchSeasonName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel_MatchAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField_MatchOpponent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel_MatchAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jSpinner_MatchDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel_MatchAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField_MatchFoulsCommitted, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel_MatchAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField_MatchFoulsConceded, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel_MatchAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField_MatchAssists, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel_MatchAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextField_MatchRebounds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel_MatchAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTextField_MatchSteals, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel_MatchAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jTextField_MatchBlocks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox_MatchHomeGame)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel_MatchAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jTextField_MatchPointsScored, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(64, 64, 64)
                        .addComponent(jLabel_MatchAddMessage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_AddMatch)))
                .addContainerGap())
        );

        jPanel_MatchUpdate.setBorder(javax.swing.BorderFactory.createTitledBorder("Update Match Data"));

        jLabel41.setText("Opponent");

        jLabel42.setText("Date");

        jLabel43.setText("Fouls Commited");

        jLabel44.setText("Fouls Conceded");

        jLabel45.setText("Assists");

        jLabel46.setText("Rebounds");

        jLabel47.setText("Steals");

        jLabel48.setText("Blocks");

        jLabel49.setText("Points Scored");

        jLabel50.setText("Points Conceded");

        jLabel51.setText("Location (City/Town)");

        jLabel_MatchUpdateId.setText(" ");

        jSpinner_MatchUpdateDate.setModel(new javax.swing.SpinnerDateModel());

        jCheckBox_MatchUpdateHomeGame.setText("Home Game");

        jLabel_MatchUpdateMessage.setText(" ");

        jButton_UpdateMatch.setText("Update");
        jButton_UpdateMatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_UpdateMatchActionPerformed(evt);
            }
        });

        jButton_UpdateMatchCancel.setText("Cancel");
        jButton_UpdateMatchCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_UpdateMatchCancelActionPerformed(evt);
            }
        });

        jLabel52.setText("Match Id");

        jLabel69.setText("Season Id & Name");

        jLabel_MatchUpdateSeasonId.setText(" ");

        jLabel_MatchUpdateSeasonName.setText(" ");
        jLabel_MatchUpdateSeasonName.setPreferredSize(new java.awt.Dimension(150, 16));

        javax.swing.GroupLayout jPanel_MatchUpdateLayout = new javax.swing.GroupLayout(jPanel_MatchUpdate);
        jPanel_MatchUpdate.setLayout(jPanel_MatchUpdateLayout);
        jPanel_MatchUpdateLayout.setHorizontalGroup(
            jPanel_MatchUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_MatchUpdateLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_MatchUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_MatchUpdateLayout.createSequentialGroup()
                        .addGroup(jPanel_MatchUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_MatchUpdateLayout.createSequentialGroup()
                                .addComponent(jButton_UpdateMatch)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_UpdateMatchCancel))
                            .addGroup(jPanel_MatchUpdateLayout.createSequentialGroup()
                                .addGroup(jPanel_MatchUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel69, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel52, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel41, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel42, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel43, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(jLabel44, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel46, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel47, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel48, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel49, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel_MatchUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel_MatchUpdateLayout.createSequentialGroup()
                                        .addGroup(jPanel_MatchUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextField_MatchUpdateOpponent)
                                            .addComponent(jTextField_MatchUpdateFoulsCommitted)
                                            .addComponent(jTextField_MatchUpdateFoulsConceded)
                                            .addComponent(jTextField_MatchUpdateAssists)
                                            .addComponent(jTextField_MatchUpdateRebounds)
                                            .addComponent(jTextField_MatchUpdateSteals)
                                            .addComponent(jTextField_MatchUpdateBlocks)
                                            .addComponent(jTextField_MatchUpdatePointsScored)
                                            .addComponent(jCheckBox_MatchUpdateHomeGame, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                            .addComponent(jSpinner_MatchUpdateDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel_MatchUpdateId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel_MatchUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel50, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel51, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel_MatchUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextField_MatchUpdatePointsConceded, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                            .addComponent(jTextField_MatchUpdateLocation)))
                                    .addGroup(jPanel_MatchUpdateLayout.createSequentialGroup()
                                        .addComponent(jLabel_MatchUpdateSeasonId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel_MatchUpdateSeasonName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(0, 53, Short.MAX_VALUE))
                    .addComponent(jLabel_MatchUpdateMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel_MatchUpdateLayout.setVerticalGroup(
            jPanel_MatchUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_MatchUpdateLayout.createSequentialGroup()
                .addGroup(jPanel_MatchUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(jLabel_MatchUpdateId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_MatchUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_MatchUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel_MatchUpdateSeasonName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel_MatchUpdateSeasonId))
                    .addComponent(jLabel69))
                .addGap(19, 19, 19)
                .addGroup(jPanel_MatchUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_MatchUpdateLayout.createSequentialGroup()
                        .addGroup(jPanel_MatchUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel41)
                            .addComponent(jTextField_MatchUpdateOpponent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel_MatchUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel42)
                            .addComponent(jSpinner_MatchUpdateDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel_MatchUpdateLayout.createSequentialGroup()
                        .addGroup(jPanel_MatchUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel50)
                            .addComponent(jTextField_MatchUpdatePointsConceded, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel_MatchUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel51)
                            .addComponent(jTextField_MatchUpdateLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_MatchUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(jTextField_MatchUpdateFoulsCommitted, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel_MatchUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(jTextField_MatchUpdateFoulsConceded, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_MatchUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(jTextField_MatchUpdateAssists, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_MatchUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(jTextField_MatchUpdateRebounds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_MatchUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(jTextField_MatchUpdateSteals, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_MatchUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(jTextField_MatchUpdateBlocks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox_MatchUpdateHomeGame)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_MatchUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(jTextField_MatchUpdatePointsScored, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jLabel_MatchUpdateMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_MatchUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_UpdateMatch)
                    .addComponent(jButton_UpdateMatchCancel))
                .addContainerGap())
        );

        jPanel_SeasonList.setBorder(javax.swing.BorderFactory.createTitledBorder("List of Seasons"));
        jPanel_SeasonList.setLayout(new java.awt.BorderLayout());

        jList_SeasonList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane1.setViewportView(jList_SeasonList);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(552, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel_SeasonList.add(jPanel10, java.awt.BorderLayout.CENTER);

        jPanel_SeasonAdd.setBorder(javax.swing.BorderFactory.createTitledBorder("Add Season"));
        jPanel_SeasonAdd.setPreferredSize(new java.awt.Dimension(970, 570));
        jPanel_SeasonAdd.setLayout(new java.awt.BorderLayout());

        jLabel65.setText("Season Name");
        jLabel65.setPreferredSize(new java.awt.Dimension(150, 16));

        jTextField_SeasonName.setPreferredSize(new java.awt.Dimension(200, 28));

        jButton_AddPlayer1.setText("Add");
        jButton_AddPlayer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AddPlayer1ActionPerformed(evt);
            }
        });

        jLabel_SeasonAddMessage.setForeground(java.awt.Color.red);
        jLabel_SeasonAddMessage.setText(" ");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_SeasonAddMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_SeasonName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton_AddPlayer1))
                        .addGap(0, 584, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_SeasonName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_SeasonAddMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 455, Short.MAX_VALUE)
                .addComponent(jButton_AddPlayer1)
                .addContainerGap())
        );

        jPanel_SeasonAdd.add(jPanel9, java.awt.BorderLayout.CENTER);

        jFileChooser_ImportExcel.setDialogTitle("Import Excel");

        jPanel_StatsSingleSeasonPlayer.setBorder(javax.swing.BorderFactory.createTitledBorder("Single Season Player's Statistics"));
        jPanel_StatsSingleSeasonPlayer.setLayout(new java.awt.BorderLayout());

        jLabel70.setText("Player");

        jLabel71.setText("Season");

        jButton_ShowStatsSingleSeasonPlayer.setText("Show Stats");
        jButton_ShowStatsSingleSeasonPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ShowStatsSingleSeasonPlayerActionPerformed(evt);
            }
        });

        jLabel_StatsSingleSeasonPlayerMessage.setText(" ");

        jLabel72.setText("Average Points Scored");

        jLabel73.setText("Average Assists");

        jLabel74.setText("Average Rebounds");

        jLabel_StatsSingleSeasonPlayerAverPointsScored.setText(" ");

        jLabel_StatsSingleSeasonPlayerAverRebounds.setText(" ");

        jLabel_StatsSingleSeasonPlayerAverAssists.setText(" ");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_StatsSingleSeasonPlayerMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel70)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox_StatsSingleSeasonPlayerPlayers, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel71)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox_StatsSingleSeasonPlayerSeasons, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_ShowStatsSingleSeasonPlayer))
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                                    .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel_StatsSingleSeasonPlayerAverAssists, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                                    .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel_StatsSingleSeasonPlayerAverRebounds, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                                    .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel_StatsSingleSeasonPlayerAverPointsScored, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 305, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel70)
                    .addComponent(jLabel71)
                    .addComponent(jButton_ShowStatsSingleSeasonPlayer)
                    .addComponent(jComboBox_StatsSingleSeasonPlayerPlayers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_StatsSingleSeasonPlayerSeasons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_StatsSingleSeasonPlayerMessage)
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel72)
                    .addComponent(jLabel_StatsSingleSeasonPlayerAverPointsScored))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel74)
                    .addComponent(jLabel_StatsSingleSeasonPlayerAverRebounds))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel73)
                    .addComponent(jLabel_StatsSingleSeasonPlayerAverAssists))
                .addContainerGap(387, Short.MAX_VALUE))
        );

        jPanel_StatsSingleSeasonPlayer.add(jPanel11, java.awt.BorderLayout.CENTER);

        jPanel_StatsSingleSeasonTeam.setBorder(javax.swing.BorderFactory.createTitledBorder("Single Season Team Statistics"));
        jPanel_StatsSingleSeasonTeam.setLayout(new java.awt.BorderLayout());

        jLabel76.setText("Season");

        jButton_ShowStatsSingleSeasonTeam.setText("Show Stats");
        jButton_ShowStatsSingleSeasonTeam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ShowStatsSingleSeasonTeamActionPerformed(evt);
            }
        });

        jLabel_StatsSingleSeasonTeamMessage.setText(" ");

        jLabel77.setText("Average Points Scored");

        jLabel79.setText("Average Points Conceded");

        jLabel_StatsSingleSeasonTeamAverPointsScored.setText(" ");

        jLabel_StatsSingleSeasonTeamAverPointsConceded.setText(" ");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_StatsSingleSeasonTeamMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel79, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                    .addComponent(jLabel77, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel_StatsSingleSeasonTeamAverPointsConceded, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel_StatsSingleSeasonTeamAverPointsScored, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel76)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox_StatsSingleSeasonTeamSeasons, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_ShowStatsSingleSeasonTeam)))
                        .addGap(0, 566, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel76)
                    .addComponent(jButton_ShowStatsSingleSeasonTeam)
                    .addComponent(jComboBox_StatsSingleSeasonTeamSeasons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_StatsSingleSeasonTeamMessage)
                .addGap(43, 43, 43)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel77)
                    .addComponent(jLabel_StatsSingleSeasonTeamAverPointsScored))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel79)
                    .addComponent(jLabel_StatsSingleSeasonTeamAverPointsConceded))
                .addContainerGap(396, Short.MAX_VALUE))
        );

        jPanel_StatsSingleSeasonTeam.add(jPanel12, java.awt.BorderLayout.CENTER);

        jPanel_StatsMultipleSeasonsPlayer.setBorder(javax.swing.BorderFactory.createTitledBorder("Multiple Seasons Player's Statistics"));
        jPanel_StatsMultipleSeasonsPlayer.setLayout(new java.awt.BorderLayout());

        jLabel75.setText("Player");

        jButton_ShowStatsMultipleSeasonsPlayer.setText("Show Stats");
        jButton_ShowStatsMultipleSeasonsPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ShowStatsMultipleSeasonsPlayerActionPerformed(evt);
            }
        });

        jLabel_StatsMultipleSeasonsPlayerMessage.setText(" ");

        jLabel80.setText("Average Points Scored");

        jLabel81.setText("Average Assists");

        jLabel82.setText("Average Rebounds");

        jLabel_StatsMultipleSeasonsPlayerAverPointsScored.setText(" ");

        jLabel_StatsMultipleSeasonsPlayerAverRebounds.setText(" ");

        jLabel_StatsMultipleSeasonsPlayerAverAssists.setText(" ");

        jList_StatsMultipleSeasonsPlayerSeasons.setBorder(javax.swing.BorderFactory.createTitledBorder("Seasons"));
        jScrollPane6.setViewportView(jList_StatsMultipleSeasonsPlayerSeasons);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_StatsMultipleSeasonsPlayerMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel75)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox_StatsMultipleSeasonsPlayerPlayers, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_ShowStatsMultipleSeasonsPlayer))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel13Layout.createSequentialGroup()
                                        .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel_StatsMultipleSeasonsPlayerAverAssists, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel13Layout.createSequentialGroup()
                                        .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel_StatsMultipleSeasonsPlayerAverRebounds, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel13Layout.createSequentialGroup()
                                        .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel_StatsMultipleSeasonsPlayerAverPointsScored, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 467, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel75)
                    .addComponent(jButton_ShowStatsMultipleSeasonsPlayer)
                    .addComponent(jComboBox_StatsMultipleSeasonsPlayerPlayers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel80)
                            .addComponent(jLabel_StatsMultipleSeasonsPlayerAverPointsScored))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel82)
                            .addComponent(jLabel_StatsMultipleSeasonsPlayerAverRebounds))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel81)
                            .addComponent(jLabel_StatsMultipleSeasonsPlayerAverAssists))
                        .addContainerGap(407, Short.MAX_VALUE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel_StatsMultipleSeasonsPlayerMessage)
                        .addGap(43, 43, 43))))
        );

        jPanel_StatsMultipleSeasonsPlayer.add(jPanel13, java.awt.BorderLayout.CENTER);

        jPanel_StatsMultipleSeasonsTeam.setBorder(javax.swing.BorderFactory.createTitledBorder("Multiple Seasons Team Statistics"));
        jPanel_StatsMultipleSeasonsTeam.setLayout(new java.awt.BorderLayout());

        jButton_ShowStatsMultipleSeasonsTeam.setText("Show Stats");
        jButton_ShowStatsMultipleSeasonsTeam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ShowStatsMultipleSeasonsTeamActionPerformed(evt);
            }
        });

        jLabel_StatsMultipleSeasonsTeamMessage.setText(" ");

        jLabel85.setText("Average Points Scored");

        jLabel87.setText("Average Points Conceded");

        jLabel_StatsMultipleSeasonsTeamAverPointsScored.setText(" ");

        jLabel_StatsMultipleSeasonsTeamAverPointsConceded.setText(" ");

        jList_StatsMultipleSeasonsTeamSeasons.setBorder(javax.swing.BorderFactory.createTitledBorder("Seasons"));
        jScrollPane7.setViewportView(jList_StatsMultipleSeasonsTeamSeasons);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_StatsMultipleSeasonsTeamMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel87, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                                    .addComponent(jLabel85, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel_StatsMultipleSeasonsTeamAverPointsConceded, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel_StatsMultipleSeasonsTeamAverPointsScored, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jButton_ShowStatsMultipleSeasonsTeam))
                        .addGap(0, 452, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_ShowStatsMultipleSeasonsTeam)
                .addGap(39, 39, 39)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel85)
                    .addComponent(jLabel_StatsMultipleSeasonsTeamAverPointsScored))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel87)
                    .addComponent(jLabel_StatsMultipleSeasonsTeamAverPointsConceded))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel_StatsMultipleSeasonsTeamMessage)
                .addGap(43, 43, 43))
        );

        jPanel_StatsMultipleSeasonsTeam.add(jPanel14, java.awt.BorderLayout.CENTER);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Basket Manager");
        setMinimumSize(new java.awt.Dimension(1000, 600));

        jPanel_MainBody.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel_MainBody.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel_MainLayout = new javax.swing.GroupLayout(jPanel_Main);
        jPanel_Main.setLayout(jPanel_MainLayout);
        jPanel_MainLayout.setHorizontalGroup(
            jPanel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_MainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel_MainBody, javax.swing.GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel_MainLayout.setVerticalGroup(
            jPanel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_MainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel_MainBody, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenu_File.setText("File");

        jMenuItem_FileImportPlayers.setText("Import Players");
        jMenuItem_FileImportPlayers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_FileImportPlayersActionPerformed(evt);
            }
        });
        jMenu_File.add(jMenuItem_FileImportPlayers);

        jMenuItem_FileImportMatches.setText("Import Matches");
        jMenuItem_FileImportMatches.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_FileImportMatchesActionPerformed(evt);
            }
        });
        jMenu_File.add(jMenuItem_FileImportMatches);

        jMenuItem_FileImportPlayersGames.setText("Import Players' Games");
        jMenuItem_FileImportPlayersGames.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_FileImportPlayersGamesActionPerformed(evt);
            }
        });
        jMenu_File.add(jMenuItem_FileImportPlayersGames);

        jMenuItem_FileExit.setText("Exit");
        jMenuItem_FileExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_FileExitActionPerformed(evt);
            }
        });
        jMenu_File.add(jMenuItem_FileExit);

        jMenuBar1.add(jMenu_File);

        jMenu_Player.setText("Player");

        jMenuItem_PlayerAdd.setText("Add Player");
        jMenuItem_PlayerAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_PlayerAddActionPerformed(evt);
            }
        });
        jMenu_Player.add(jMenuItem_PlayerAdd);

        jMenuItem_PlayerList.setText("Players List");
        jMenuItem_PlayerList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_PlayerListActionPerformed(evt);
            }
        });
        jMenu_Player.add(jMenuItem_PlayerList);

        jMenuItem_PlayerAddGame.setText("Add Game");
        jMenuItem_PlayerAddGame.setActionCommand("Players List");
        jMenuItem_PlayerAddGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_PlayerAddGameActionPerformed(evt);
            }
        });
        jMenu_Player.add(jMenuItem_PlayerAddGame);

        jMenuItem_PlayerGameList.setText("Players' Games List");
        jMenuItem_PlayerGameList.setActionCommand("Players List");
        jMenuItem_PlayerGameList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_PlayerGameListActionPerformed(evt);
            }
        });
        jMenu_Player.add(jMenuItem_PlayerGameList);

        jMenuBar1.add(jMenu_Player);

        jMenu_MatchData.setText("Match Data");

        jMenuItem_MatchAddNew.setText("Add New Match");
        jMenuItem_MatchAddNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_MatchAddNewActionPerformed(evt);
            }
        });
        jMenu_MatchData.add(jMenuItem_MatchAddNew);

        jMenuItem_MatchList.setText("Matches List");
        jMenuItem_MatchList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_MatchListActionPerformed(evt);
            }
        });
        jMenu_MatchData.add(jMenuItem_MatchList);

        jMenuBar1.add(jMenu_MatchData);

        jMenu_Season.setText("Season");

        jMenuItem_SeasonAddSeason.setText("Add New");
        jMenuItem_SeasonAddSeason.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_SeasonAddSeasonActionPerformed(evt);
            }
        });
        jMenu_Season.add(jMenuItem_SeasonAddSeason);

        jMenuItem_SeasonList.setText("Seasons List");
        jMenuItem_SeasonList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_SeasonListActionPerformed(evt);
            }
        });
        jMenu_Season.add(jMenuItem_SeasonList);

        jMenuBar1.add(jMenu_Season);

        jMenu_Statictis.setText("Statistics");

        jMenu_SingleSeason.setText("Single Season");

        jMenuItem_SingleSeasonPlayer.setText("Player");
        jMenuItem_SingleSeasonPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_SingleSeasonPlayerActionPerformed(evt);
            }
        });
        jMenu_SingleSeason.add(jMenuItem_SingleSeasonPlayer);

        jMenuItem_SingleSeasonTeam.setText("Team");
        jMenuItem_SingleSeasonTeam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_SingleSeasonTeamActionPerformed(evt);
            }
        });
        jMenu_SingleSeason.add(jMenuItem_SingleSeasonTeam);

        jMenu_Statictis.add(jMenu_SingleSeason);

        jMenu_MultipleSeasons.setText("Multiple Seasons");

        jMenuItem_MultipleSeasonPlayer.setText("Player");
        jMenuItem_MultipleSeasonPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_MultipleSeasonPlayerActionPerformed(evt);
            }
        });
        jMenu_MultipleSeasons.add(jMenuItem_MultipleSeasonPlayer);

        jMenuItem_MultipleSeasonTeam.setText("Team");
        jMenuItem_MultipleSeasonTeam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_MultipleSeasonTeamActionPerformed(evt);
            }
        });
        jMenu_MultipleSeasons.add(jMenuItem_MultipleSeasonTeam);

        jMenu_Statictis.add(jMenu_MultipleSeasons);

        jMenuBar1.add(jMenu_Statictis);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_Main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_Main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem_FileExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_FileExitActionPerformed
        int exitConfirmation = JOptionPane.showConfirmDialog(jPanel_Main, "Do you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
        if (exitConfirmation == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jMenuItem_FileExitActionPerformed

    private void jMenuItem_SeasonListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_SeasonListActionPerformed
        displaySeasonList();
    }//GEN-LAST:event_jMenuItem_SeasonListActionPerformed

    private void jMenuItem_SeasonAddSeasonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_SeasonAddSeasonActionPerformed
        displaySeasonAdd();
    }//GEN-LAST:event_jMenuItem_SeasonAddSeasonActionPerformed

    private void jMenuItem_MatchAddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_MatchAddNewActionPerformed
        displayMatchAdd();
    }//GEN-LAST:event_jMenuItem_MatchAddNewActionPerformed

    private void jMenuItem_PlayerAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_PlayerAddActionPerformed
        displayPlayerAdd();
    }//GEN-LAST:event_jMenuItem_PlayerAddActionPerformed

    private void jButton_AddPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AddPlayerActionPerformed
        addPlayer();
    }//GEN-LAST:event_jButton_AddPlayerActionPerformed

    private void jButton_AddPlayerGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AddPlayerGameActionPerformed

        addPlayerGame();
    }//GEN-LAST:event_jButton_AddPlayerGameActionPerformed

    private void jMenuItem_PlayerListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_PlayerListActionPerformed
        displayPlayerList();
    }//GEN-LAST:event_jMenuItem_PlayerListActionPerformed

    private void jButton_AddMatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AddMatchActionPerformed
        addMatch();
    }//GEN-LAST:event_jButton_AddMatchActionPerformed

    private void jMenuItem_MatchListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_MatchListActionPerformed

        displayMatchList();
    }//GEN-LAST:event_jMenuItem_MatchListActionPerformed

    private void jMenuItem_PlayerAddGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_PlayerAddGameActionPerformed
        displayPlayerGameAdd();
    }//GEN-LAST:event_jMenuItem_PlayerAddGameActionPerformed

    private void jMenuItem_PlayerGameListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_PlayerGameListActionPerformed
        displayPlayerGameList();
    }//GEN-LAST:event_jMenuItem_PlayerGameListActionPerformed

    private void jButton_UpdatePlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_UpdatePlayerActionPerformed
        updatePlayer();
    }//GEN-LAST:event_jButton_UpdatePlayerActionPerformed

    private void jButton_UpdatePlayerCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_UpdatePlayerCancelActionPerformed
        displayPlayerList();
    }//GEN-LAST:event_jButton_UpdatePlayerCancelActionPerformed

    private void jButton_UpdateMatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_UpdateMatchActionPerformed
        updateMatch();
    }//GEN-LAST:event_jButton_UpdateMatchActionPerformed

    private void jButton_UpdateMatchCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_UpdateMatchCancelActionPerformed
        displayMatchList();
    }//GEN-LAST:event_jButton_UpdateMatchCancelActionPerformed

    private void jButton_UpdatePlayerGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_UpdatePlayerGameActionPerformed
        updatePlayerGame();
    }//GEN-LAST:event_jButton_UpdatePlayerGameActionPerformed

    private void jButton_UpdatePlayerGameCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_UpdatePlayerGameCancelActionPerformed
        displayPlayerGameList();
    }//GEN-LAST:event_jButton_UpdatePlayerGameCancelActionPerformed

    private void jButton_DeletePlayerGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DeletePlayerGameActionPerformed
        deletePlayerGame();
    }//GEN-LAST:event_jButton_DeletePlayerGameActionPerformed

    private void jButton_AddPlayer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AddPlayer1ActionPerformed
        addSeason();
    }//GEN-LAST:event_jButton_AddPlayer1ActionPerformed

    private void jButton_DeleteMatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DeleteMatchActionPerformed
        deleteMatch();
    }//GEN-LAST:event_jButton_DeleteMatchActionPerformed

    private void jButton_DeletePlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DeletePlayerActionPerformed
        deletePlayer();
    }//GEN-LAST:event_jButton_DeletePlayerActionPerformed

    private void jMenuItem_FileImportPlayersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_FileImportPlayersActionPerformed
        displayImportExcel(ImportDialogType.PLAYERS);
    }//GEN-LAST:event_jMenuItem_FileImportPlayersActionPerformed

    private void jMenuItem_FileImportPlayersGamesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_FileImportPlayersGamesActionPerformed
        displayImportExcel(ImportDialogType.PLAYERS_GAMES);
    }//GEN-LAST:event_jMenuItem_FileImportPlayersGamesActionPerformed

    private void jMenuItem_FileImportMatchesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_FileImportMatchesActionPerformed
        displayImportExcel(ImportDialogType.MATCHES);
    }//GEN-LAST:event_jMenuItem_FileImportMatchesActionPerformed

    private void jMenuItem_SingleSeasonPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_SingleSeasonPlayerActionPerformed
        displayStatsSingleSeasonPlayer();
    }//GEN-LAST:event_jMenuItem_SingleSeasonPlayerActionPerformed

    private void jButton_ShowStatsSingleSeasonPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ShowStatsSingleSeasonPlayerActionPerformed
        calculateStatSingleSeasonPlayer();
    }//GEN-LAST:event_jButton_ShowStatsSingleSeasonPlayerActionPerformed

    private void jButton_ShowStatsSingleSeasonTeamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ShowStatsSingleSeasonTeamActionPerformed
        calculateStatSingleSeasonTeam();
    }//GEN-LAST:event_jButton_ShowStatsSingleSeasonTeamActionPerformed

    private void jMenuItem_SingleSeasonTeamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_SingleSeasonTeamActionPerformed
        displayStatsSingleSeasonTeam();
    }//GEN-LAST:event_jMenuItem_SingleSeasonTeamActionPerformed

    private void jButton_ShowStatsMultipleSeasonsPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ShowStatsMultipleSeasonsPlayerActionPerformed
        calculateStatMultipleSeasonsPlayer();
    }//GEN-LAST:event_jButton_ShowStatsMultipleSeasonsPlayerActionPerformed

    private void jMenuItem_MultipleSeasonPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_MultipleSeasonPlayerActionPerformed
        displayStatsMultipleSeasonsPlayer();
    }//GEN-LAST:event_jMenuItem_MultipleSeasonPlayerActionPerformed

    private void jButton_ShowStatsMultipleSeasonsTeamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ShowStatsMultipleSeasonsTeamActionPerformed
        calculateStatMultipleSeasonsTeam();
    }//GEN-LAST:event_jButton_ShowStatsMultipleSeasonsTeamActionPerformed

    private void jMenuItem_MultipleSeasonTeamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_MultipleSeasonTeamActionPerformed
        displayStatsMultipleSeasonsTeam();
    }//GEN-LAST:event_jMenuItem_MultipleSeasonTeamActionPerformed

    // =====================================================================================
    // Display methods
    private void displayPlayerList() {

        ArrayList<PlayerRecord> allPlayers = DatabaseManager.getAllPlayerEntries();

        DefaultTableModel tableModel = (DefaultTableModel) jTable_PlayersList.getModel();
        tableModel.setRowCount(0); // Clear table model

        for (PlayerRecord player : allPlayers) {
            Object[] tmpPlayerRow = new Object[]{
                player.getId(),
                player.getFirstName().trim(),
                player.getLastName().trim(),
                player.getDoB().trim(),
                player.getPoB().trim(),
                player.getHeight().trim(),
                player.getWeight().trim(),
                player.getPosition().trim(),
                player.getJersey().trim()
            };

            tableModel.addRow(tmpPlayerRow);
        }

        changeMainBodyContent(jPanel_PlayerList);
    }

    private void displayPlayerAdd() {
        jLabel_PlayerAddMessage.setText("");

        clearAddPlayer();

        changeMainBodyContent(jPanel_PlayerAdd);
    }

    private void displayPlayerUpdate(JTable jTable, int row) {
        try {
            int PlayerId = Integer.parseInt(jTable.getValueAt(row, 0).toString());

            FileDatabaseManagerPlayer fileDatabaseManagerPlayer = new FileDatabaseManagerPlayer();
            PlayerRecord tmpPlayerRecord = (PlayerRecord) fileDatabaseManagerPlayer.getRecord(PlayerId);

            jLabel_PlayerUpdateId.setText(Integer.toString(tmpPlayerRecord.getId()));
            jTextField_PlayerUpdateFirstName.setText(tmpPlayerRecord.getFirstName());
            jTextField_PlayerUpdateLastName.setText(tmpPlayerRecord.getLastName());
            jTextField_PlayerUpdateDoB.setText(tmpPlayerRecord.getDoB());
            jTextField_PlayerUpdatePoB.setText(tmpPlayerRecord.getPoB());
            jTextField_PlayerUpdateHeight.setText(tmpPlayerRecord.getHeight());
            jTextField_PlayerUpdateWeight.setText(tmpPlayerRecord.getWeight());
            jTextField_PlayerUpdatePosition.setText(tmpPlayerRecord.getPosition());
            jTextField_PlayerUpdateJersey.setText(tmpPlayerRecord.getJersey());

            jLabel_PlayerUpdateMessage.setText("");

            changeMainBodyContent(jPanel_PlayerUpdate);
        } catch (IOException ex) {
            Logger.getLogger(BasketManagerJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void displayPlayerGameList() {
        ArrayList<PlayerGameRecord> allPlayerGameRecords = DatabaseManager.getAllPlayerGamesEntries();

        DefaultTableModel tableModel = (DefaultTableModel) jTable_PlayerGamesList.getModel();
        tableModel.setRowCount(0); // Clear table model

        for (PlayerGameRecord record : allPlayerGameRecords) {
            Object[] tmpPlayerGameRow = new Object[]{
                record.getId(),
                record.getSeasonName().trim(),
                record.getPlayerName().trim(),
                record.getFoulsCommitted().trim(),
                record.getFoulsConceded().trim(),
                record.getAssists().trim(),
                record.getRebounds().trim(),
                record.getSteals().trim(),
                record.getBlocks().trim(),
                (record.getHomeGame() == 1 ? true : false),
                record.getAwayTeamName().trim(),
                record.getPointsScored().trim(),
                record.getLocation().trim(),
                new Date(record.getGameDate())
            };

            tableModel.addRow(tmpPlayerGameRow);
        }

        changeMainBodyContent(jPanel_PlayerGameList);
    }

    private void displayPlayerGameAdd() {
        jLabel_PlayerGameAddMessage.setText("");

        clearAddPlayerGame();

        boolean hasPlayers = loadAllPlayersForPlayerGameAdd();

        boolean hasSeasons = loadAllSeasonsForPlayerGameAdd();

        boolean enableAddPlayerGameButton = hasPlayers && hasSeasons;

        jButton_AddPlayerGame.setEnabled(enableAddPlayerGameButton);

        changeMainBodyContent(jPanel_PlayerGameAdd);
    }

    private void displayPlayerGameUpdate(JTable jTable, int row) {
        try {
            int GameId = Integer.parseInt(jTable.getValueAt(row, 0).toString());

            FileDatabaseManagerPlayerGame fileDatabaseManagerPlayerGame = new FileDatabaseManagerPlayerGame();
            PlayerGameRecord tmpPlayerGameRecord = (PlayerGameRecord) fileDatabaseManagerPlayerGame.getRecord(GameId);

            jLabel_PlayerGameUpdateGameId.setText(Integer.toString(tmpPlayerGameRecord.getId()));
            jLabel_PlayerGameUpdateSeasonId.setText(Integer.toString(tmpPlayerGameRecord.getSeasonId()));
            jLabel_PlayerGameUpdateSeasonName.setText(tmpPlayerGameRecord.getSeasonName());
            jLabel_PlayerGameUpdatePlayerId.setText(Integer.toString(tmpPlayerGameRecord.getPlayerId()));
            jLabel_PlayerGameUpdatePlayerName.setText(tmpPlayerGameRecord.getPlayerName());
            jTextField_PlayerGameUpdateFoulsCommitted.setText(tmpPlayerGameRecord.getFoulsCommitted());
            jTextField_PlayerGameUpdateFoulsConceded.setText(tmpPlayerGameRecord.getFoulsConceded());
            jTextField_PlayerGameUpdateAssists.setText(tmpPlayerGameRecord.getAssists());
            jTextField_PlayerGameUpdateRebounds.setText(tmpPlayerGameRecord.getRebounds());
            jTextField_PlayerGameUpdateSteals.setText(tmpPlayerGameRecord.getSteals());
            jTextField_PlayerGameUpdateBlocks.setText(tmpPlayerGameRecord.getBlocks());
            jCheckBox_PlayerGameUpdateHomeGame.setSelected(tmpPlayerGameRecord.getHomeGame() == 1 ? true : false); // 1 is for Home game and 0 for Away
            jTextField_PlayerGameUpdateAwayTeamName.setText(tmpPlayerGameRecord.getAwayTeamName());
            jTextField_PlayerGameUpdatePointsScored.setText(tmpPlayerGameRecord.getPointsScored());
            jTextField_PlayerGameUpdateLocation.setText(tmpPlayerGameRecord.getLocation());
            jSpinner_PlayerGameUpdateDate.setValue(new Date(tmpPlayerGameRecord.getGameDate())); // The long number is the timpestamp, use Date class to convert it to Date

            jLabel_PlayerGameUpdateMessage.setText("");

            changeMainBodyContent(jPanel_PlayerGameUpdate);

        } catch (IOException ex) {
            Logger.getLogger(BasketManagerJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void displayMatchList() {
        ArrayList<MatchRecord> allMatches = DatabaseManager.getAllMatchesEntries();

        DefaultTableModel tableModel = (DefaultTableModel) jTable_MatchesList.getModel();
        tableModel.setRowCount(0); // Clear table model

        for (MatchRecord record : allMatches) {
            Object[] tmpMatchRow = new Object[]{
                record.getId(),
                record.getSeasonName().trim(),
                record.getOpponent().trim(),
                new Date(record.getDate()),
                record.getFoulsCommitted().trim(),
                record.getFoulsConceded().trim(),
                record.getAssists().trim(),
                record.getRebounds().trim(),
                record.getSteals().trim(),
                record.getBlocks().trim(),
                (record.getHomeGame() == 1 ? true : false),
                record.getPointsScored().trim(),
                record.getPointsConceded().trim(),
                record.getLocation().trim()
            };

            tableModel.addRow(tmpMatchRow);
        }

        changeMainBodyContent(jPanel_MatchList);
    }

    private void displayMatchAdd() {
        clearAddMatch();

        boolean hasSeasons = loadAllSeasonsForMatchAdd();

        boolean enableAddPlayerGameButton = hasSeasons;

        jButton_AddMatch.setEnabled(enableAddPlayerGameButton);

        changeMainBodyContent(jPanel_MatchAdd);
    }

    private void displayMatchUpdate(JTable jTable, int row) {
        try {
            int MatchId = Integer.parseInt(jTable.getValueAt(row, 0).toString());

            FileDatabaseManagerMatch fileDatabaseManagerMatch = new FileDatabaseManagerMatch();
            MatchRecord tmpMatchRecord = (MatchRecord) fileDatabaseManagerMatch.getRecord(MatchId);

            jLabel_MatchUpdateId.setText(Integer.toString(tmpMatchRecord.getId()));
            jLabel_MatchUpdateSeasonId.setText(Integer.toString(tmpMatchRecord.getSeasonId()));
            jLabel_MatchUpdateSeasonName.setText(tmpMatchRecord.getSeasonName());
            jTextField_MatchUpdateOpponent.setText(tmpMatchRecord.getOpponent());

            jSpinner_MatchUpdateDate.setValue(new Date(tmpMatchRecord.getDate())); // The long number is the timpestamp, use Date class to convert it to Date

            jTextField_MatchUpdateFoulsCommitted.setText(tmpMatchRecord.getFoulsCommitted());
            jTextField_MatchUpdateFoulsConceded.setText(tmpMatchRecord.getFoulsConceded());
            jTextField_MatchUpdateAssists.setText(tmpMatchRecord.getAssists());
            jTextField_MatchUpdateRebounds.setText(tmpMatchRecord.getRebounds());
            jTextField_MatchUpdateSteals.setText(tmpMatchRecord.getSteals());
            jTextField_MatchUpdateBlocks.setText(tmpMatchRecord.getBlocks());
            jCheckBox_MatchUpdateHomeGame.setSelected(tmpMatchRecord.getHomeGame() == 1 ? true : false); // 1 is for Home game and 0 for Away
            jTextField_MatchUpdatePointsScored.setText(tmpMatchRecord.getPointsScored());
            jTextField_MatchUpdatePointsConceded.setText(tmpMatchRecord.getPointsConceded());
            jTextField_MatchUpdateLocation.setText(tmpMatchRecord.getLocation());

            jLabel_MatchUpdateMessage.setText("");

            changeMainBodyContent(jPanel_MatchUpdate);
        } catch (IOException ex) {
            Logger.getLogger(BasketManagerJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void displaySeasonList() {
        try {
            ArrayList<SeasonRecord> allSeasons = DatabaseManager.getAllSeasonEntries();

            DefaultListModel listModel = new DefaultListModel();

            for (SeasonRecord record : allSeasons) {
                listModel.addElement(record.getId() + "." + record.getSeasonName().trim());

                jList_SeasonList.setModel(listModel);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BasketManagerJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        changeMainBodyContent(jPanel_SeasonList);
    }

    private void displaySeasonAdd() {
        jLabel_SeasonAddMessage.setText("");

        clearAddSeason();

        changeMainBodyContent(jPanel_SeasonAdd);
    }

    private void displayImportExcel(ImportDialogType importDialogType) {
        try {
            int clickedButton = jFileChooser_ImportExcel.showDialog(this, "Select");

            File choosedFile = jFileChooser_ImportExcel.getSelectedFile();

            String filePath = choosedFile.getAbsolutePath();
            
            String dialogMessage = "";
            
            switch (importDialogType) {
                case PLAYERS:
                    dialogMessage = ImportManager.ImportEntries(importDialogType, filePath);
                    break;
                case PLAYERS_GAMES:
                    dialogMessage = ImportManager.ImportEntries(importDialogType, filePath);
                    break;
                case MATCHES:
                    dialogMessage = ImportManager.ImportEntries(importDialogType, filePath);
                    break;
            }
            
            // In case of Cancel button do nothing
            if(clickedButton == JFileChooser.APPROVE_OPTION){
                JOptionPane.showMessageDialog(jPanel_Main, dialogMessage);
            }
            
        } catch (IOException | ParseException ex) {
            JOptionPane.showMessageDialog(jPanel_Main, "Error during data import: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(BasketManagerJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void displayStatsSingleSeasonPlayer() {
        jLabel_StatsSingleSeasonPlayerMessage.setText("");

        clearStatsSingleSeasonPlayer();

        boolean hasPlayers = loadAllPlayersForStatsSingleSeasonPlayer();

        boolean hasSeasons = loadAllSeasonsForStatsSingleSeasonPlayer();

        boolean enableShowStatsButton = hasPlayers && hasSeasons;

        jButton_ShowStatsSingleSeasonPlayer.setEnabled(enableShowStatsButton);

        changeMainBodyContent(jPanel_StatsSingleSeasonPlayer);
    }

    private void displayStatsSingleSeasonTeam() {
        jLabel_StatsSingleSeasonTeamMessage.setText("");

        clearStatsSingleSeasonTeam();

        boolean hasSeasons = loadAllSeasonsForStatsSingleSeasonTeam();

        boolean enableShowStatsButton = hasSeasons;
        
        // Check if there are any matches, if not, show error message, lock button
        if(DatabaseManager.getAllMatchesEntries().size() < 1 ) {
            jLabel_StatsSingleSeasonTeamMessage.setText("There is no available matches!");
            jLabel_StatsSingleSeasonTeamMessage.setForeground(Color.RED);
            
            enableShowStatsButton = false;
        }

        jButton_ShowStatsSingleSeasonTeam.setEnabled(enableShowStatsButton);

        changeMainBodyContent(jPanel_StatsSingleSeasonTeam);
    }
    
    private void displayStatsMultipleSeasonsPlayer() {
        
        jLabel_StatsMultipleSeasonsPlayerMessage.setText("");

        clearStatsMultipleSeasonsPlayer();

        boolean hasPlayers = loadAllPlayersForStatsMultipleSeasonsPlayer();

        boolean hasSeasons = loadAllSeasonsForStatsMultipleSeasonsPlayer();

        boolean enableShowStatsButton = hasPlayers && hasSeasons;

        jButton_ShowStatsMultipleSeasonsPlayer.setEnabled(enableShowStatsButton);

        changeMainBodyContent(jPanel_StatsMultipleSeasonsPlayer);
    }

    private void displayStatsMultipleSeasonsTeam() {
        
        jLabel_StatsMultipleSeasonsTeamMessage.setText("");

        clearStatsMultipleSeasonsTeam();

        boolean hasSeasons = loadAllSeasonsForStatsMultipleSeasonsTeam();

        boolean enableShowStatsButton = hasSeasons;

        // Check if there are any matches, if not, show error message, lock button
        if(DatabaseManager.getAllMatchesEntries().size() < 1 ) {
            jLabel_StatsMultipleSeasonsTeamMessage.setText("There is no available matches!");
            jLabel_StatsMultipleSeasonsTeamMessage.setForeground(Color.RED);
            
            enableShowStatsButton = false;
        }
        
        jButton_ShowStatsMultipleSeasonsTeam.setEnabled(enableShowStatsButton);

        changeMainBodyContent(jPanel_StatsMultipleSeasonsTeam);
    }
    
    // =====================================================================================
    // Actions methods
    private void addPlayer() throws IllegalArgumentException {
        String FirstName = jTextField_PlayerFirstName.getText().trim();
        String LastName = jTextField_PlayerLastName.getText().trim();
        String DoB = jTextField_PlayerDoB.getText().trim();
        String PoB = jTextField_PlayerPoB.getText().trim();
        String Height = jTextField_PlayerHeight.getText().trim();
        String Weight = jTextField_PlayerWeight.getText().trim();
        String Position = jTextField_PlayerPosition.getText().trim();
        String Jersey = jTextField_PlayerJersey.getText().trim();
        int IsDeleted = 0; // not deleted

        if (!FirstName.equals("") && !LastName.equals("") && !DoB.equals("")
                && !PoB.equals("") && !Height.equals("") && !Weight.equals("")
                && !Position.equals("") && !Jersey.equals("")) {

            try {
                FileDatabaseManagerPlayer fileDatabaseManagerPlayer = new FileDatabaseManagerPlayer();

                PlayerRecord newPlayerRecord = new PlayerRecord(DatabaseManager.generateNewEntryId(GlobalVariables.pathPlayersRaf), FirstName, LastName, DoB, PoB, Height, Weight, Position, Jersey, IsDeleted);

                fileDatabaseManagerPlayer.insertRecord(newPlayerRecord);
            } catch (IOException ex) {
                Logger.getLogger(BasketManagerJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

            jLabel_PlayerAddMessage.setText("Player added successfully");
            jLabel_PlayerAddMessage.setForeground(Color.BLUE);

            clearAddPlayer();
        } else {
            jLabel_PlayerAddMessage.setText("All fields should be filled!");
            jLabel_PlayerAddMessage.setForeground(Color.RED);
        }
    }

    private void updatePlayer() throws IllegalArgumentException {
        int Id = Integer.parseInt(jLabel_PlayerUpdateId.getText());
        String FirstName = jTextField_PlayerUpdateFirstName.getText().trim();
        String LastName = jTextField_PlayerUpdateLastName.getText().trim();
        String DoB = jTextField_PlayerUpdateDoB.getText().trim();
        String PoB = jTextField_PlayerUpdatePoB.getText().trim();
        String Height = jTextField_PlayerUpdateHeight.getText().trim();
        String Weight = jTextField_PlayerUpdateWeight.getText().trim();
        String Position = jTextField_PlayerUpdatePosition.getText().trim();
        String Jersey = jTextField_PlayerUpdateJersey.getText().trim();
        int IsDeleted = 0; // not deleted

        if (!FirstName.equals("") && !LastName.equals("") && !DoB.equals("")
                && !PoB.equals("") && !Height.equals("") && !Weight.equals("")
                && !Position.equals("") && !Jersey.equals("")) {

            try {
                FileDatabaseManagerPlayer fileDatabaseManagerPlayer = new FileDatabaseManagerPlayer();

                PlayerRecord updatePlayerRecord = new PlayerRecord(Id, FirstName, LastName, DoB, PoB, Height, Weight, Position, Jersey, IsDeleted);

                fileDatabaseManagerPlayer.updateRecord(updatePlayerRecord);

            } catch (IOException ex) {
                Logger.getLogger(BasketManagerJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

            jLabel_PlayerUpdateMessage.setText("Player added successfully");
            jLabel_PlayerUpdateMessage.setForeground(Color.BLUE);

            clearUpdatePlayer();

            displayPlayerList();
        } else {
            jLabel_PlayerUpdateMessage.setText("All fields should be filled!");
            jLabel_PlayerUpdateMessage.setForeground(Color.RED);
        }
    }

    private void deletePlayer() {
        try {
            int selectedRow = jTable_PlayersList.getSelectedRow();
            // -1 is the response when none of the rows are selected
            if (selectedRow != -1) {
                int PlayerId = Integer.parseInt(jTable_PlayersList.getValueAt(selectedRow, 0).toString());;

                FileDatabaseManagerPlayer fileDatabaseManagerPlayer = new FileDatabaseManagerPlayer();

                // Get the Player record
                PlayerRecord deletePlayerRecord = (PlayerRecord) fileDatabaseManagerPlayer.getRecord(PlayerId);
                deletePlayerRecord.setIsDeleted(1); // set flag to 1 

                int deleteConfirmation = JOptionPane.showConfirmDialog(jPanel_Main, "By deleting this player the games linked with them will also be deleted?", "Delete Player", JOptionPane.YES_NO_OPTION);
                if (deleteConfirmation == JOptionPane.YES_OPTION) {
                    // Delete the record
                    fileDatabaseManagerPlayer.deleteRecord(deletePlayerRecord);

                    // Reload page to refresh the table
                    displayPlayerList();

                    jLabel_PlayerDeleteMessage.setText("Entry successfully deleted");
                    jLabel_PlayerDeleteMessage.setForeground(Color.BLUE);
                } else {
                    jLabel_PlayerDeleteMessage.setText("");
                }
            } else {
                jLabel_PlayerDeleteMessage.setText("You need to select one record first");
                jLabel_PlayerDeleteMessage.setForeground(Color.RED);
            }
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(BasketManagerJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BasketManagerJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String[] splitIdAndName(String playerInfo) {
        String[] idAndName = new String[2];

        // indexOf to get the first occurrence of our splitter character '.'
        int splitterPosition = playerInfo.indexOf('.');

        // The first position of the array is for the Player's Id
        idAndName[0] = playerInfo.substring(0, splitterPosition).trim();

        // The second position of the array is for the Player's Name
        idAndName[1] = playerInfo.substring(splitterPosition + 1).trim();

        return idAndName;
    }

    private void addPlayerGame() throws IllegalArgumentException, NumberFormatException {
        String tmpSeasonData = jComboBox_PlayerGameSeasonName.getSelectedItem().toString();
        String[] tmpSeasonIdAndName = splitIdAndName(tmpSeasonData);
        int SeasonId = Integer.parseInt(tmpSeasonIdAndName[0]); // Convert string to int
        String SeasonName = tmpSeasonIdAndName[1];

        String tmpPlayerData = jComboBox_PlayerGamePlayerName.getSelectedItem().toString();
        String[] tmpIdAndName = splitIdAndName(tmpPlayerData);
        int PlayerId = Integer.parseInt(tmpIdAndName[0]); // Convert string to int
        String PlayerName = tmpIdAndName[1];

        String FoulsCommitted = jTextField_PlayerGameFoulsCommitted.getText().trim();
        String FoulsConceded = jTextField_PlayerGameFoulsConceded.getText().trim();
        String Assists = jTextField_PlayerGameAssists.getText().trim();
        String Rebounds = jTextField_PlayerGameRebounds.getText().trim();
        String Steals = jTextField_PlayerGameSteals.getText().trim();
        String Blocks = jTextField_PlayerGameBlocks.getText().trim();
        int HomeGame = jCheckBox_PlayerGameHomeGame.isSelected() ? 1 : 0; // 0 = false or 1 = true
        String AwayTeamName = jTextField_PlayerGameAwayTeamName.getText().trim();
        String PointsScored = jTextField_PlayerGamePointsScored.getText().trim();
        String Location = jTextField_PlayerGameLocation.getText().trim();
        Date tmpDate = (Date) jSpinner_PlayerGameDate.getValue();
        long GameDate = tmpDate.getTime();
        int IsDeleted = 0; // not deleted

        if (!FoulsCommitted.equals("") && !FoulsConceded.equals("") && !Assists.equals("")
                && !Rebounds.equals("") && !Steals.equals("") && !Blocks.equals("")
                && !AwayTeamName.equals("") && !PointsScored.equals("") && !Location.equals("")) {

            try {
                FileDatabaseManagerPlayerGame fileDatabaseManagerPlayerGame = new FileDatabaseManagerPlayerGame();
                PlayerGameRecord newPlayerGameRecord = new PlayerGameRecord(DatabaseManager.generateNewEntryId(GlobalVariables.pathPlayersGamesRaf), SeasonId, SeasonName, PlayerId, PlayerName, FoulsCommitted, FoulsConceded, Assists, Rebounds, Steals, Blocks, HomeGame, AwayTeamName, PointsScored, Location, GameDate, IsDeleted);
                fileDatabaseManagerPlayerGame.insertRecord(newPlayerGameRecord);
            } catch (IOException ex) {
                Logger.getLogger(BasketManagerJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

            clearAddPlayerGame();

            boolean hasPlayers = loadAllPlayersForPlayerGameAdd();

            boolean hasSeasons = loadAllSeasonsForPlayerGameAdd();

            boolean enableAddPlayerGameButton = hasPlayers && hasSeasons;

            jButton_AddPlayerGame.setEnabled(enableAddPlayerGameButton);

            jLabel_PlayerGameAddMessage.setText("Player game added successfully");
            jLabel_PlayerGameAddMessage.setForeground(Color.BLUE);
        } else {
            jLabel_PlayerGameAddMessage.setText("All fields should be filled!");
            jLabel_PlayerGameAddMessage.setForeground(Color.RED);
        }
    }

    private void updatePlayerGame() throws IllegalArgumentException, NumberFormatException {
        int GameId = Integer.parseInt(jLabel_PlayerGameUpdatePlayerId.getText());
        int SeasonId = Integer.parseInt(jLabel_PlayerGameUpdateSeasonId.getText());
        String SeasonName = jLabel_PlayerGameUpdateSeasonName.getText();
        int PlayerId = Integer.parseInt(jLabel_PlayerGameUpdatePlayerId.getText());
        String PlayerName = jLabel_PlayerGameUpdatePlayerName.getText();
        String FoulsCommitted = jTextField_PlayerGameUpdateFoulsCommitted.getText().trim();
        String FoulsConceded = jTextField_PlayerGameUpdateFoulsConceded.getText().trim();
        String Assists = jTextField_PlayerGameUpdateAssists.getText().trim();
        String Rebounds = jTextField_PlayerGameUpdateRebounds.getText().trim();
        String Steals = jTextField_PlayerGameUpdateSteals.getText().trim();
        String Blocks = jTextField_PlayerGameUpdateBlocks.getText().trim();
        int HomeGame = jCheckBox_PlayerGameUpdateHomeGame.isSelected() ? 1 : 0; // 0 = false or 1 = true
        String AwayTeamName = jTextField_PlayerGameUpdateAwayTeamName.getText().trim();
        String PointsScored = jTextField_PlayerGameUpdatePointsScored.getText().trim();
        String Location = jTextField_PlayerGameUpdateLocation.getText().trim();
        Date tmpDate = (Date) jSpinner_PlayerGameUpdateDate.getValue();
        long GameDate = tmpDate.getTime();
        int IsDeleted = 0; // not deleted

        if (!FoulsCommitted.equals("") && !FoulsConceded.equals("") && !Assists.equals("")
                && !Rebounds.equals("") && !Steals.equals("") && !Blocks.equals("")
                && !AwayTeamName.equals("") && !PointsScored.equals("") && !Location.equals("")) {

            try {
                FileDatabaseManagerPlayerGame fileDatabaseManagerPlayerGame = new FileDatabaseManagerPlayerGame();
                PlayerGameRecord updatePlayerGameRecord = new PlayerGameRecord(GameId, SeasonId, SeasonName, PlayerId, PlayerName, FoulsCommitted, FoulsConceded, Assists, Rebounds, Steals, Blocks, HomeGame, AwayTeamName, PointsScored, Location, GameDate, IsDeleted);
                fileDatabaseManagerPlayerGame.updateRecord(updatePlayerGameRecord);
            } catch (IOException ex) {
                Logger.getLogger(BasketManagerJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

            jLabel_PlayerGameUpdateMessage.setText("Player game updated successfully");
            jLabel_PlayerGameUpdateMessage.setForeground(Color.BLUE);

            displayPlayerGameList();
        } else {
            jLabel_PlayerGameUpdateMessage.setText("All fields should be filled!");
            jLabel_PlayerGameUpdateMessage.setForeground(Color.RED);
        }
    }

    private void deletePlayerGame() {
        try {
            int selectedRow = jTable_PlayerGamesList.getSelectedRow();
            // -1 is the response when none of the rows are selected
            if (selectedRow != -1) {
                int GameId = Integer.parseInt(jTable_PlayerGamesList.getValueAt(selectedRow, 0).toString());;

                FileDatabaseManagerPlayerGame fileDatabaseManagerPlayerGame = new FileDatabaseManagerPlayerGame();

                // Get the player game record
                PlayerGameRecord deletePlayerGameRecord = (PlayerGameRecord) fileDatabaseManagerPlayerGame.getRecord(GameId);
                deletePlayerGameRecord.setIsDeleted(1); // set flag to 1 

                int deleteConfirmation = JOptionPane.showConfirmDialog(jPanel_Main, "Are you sure that you want to delete this game?", "Delete Player Game", JOptionPane.YES_NO_OPTION);
                if (deleteConfirmation == JOptionPane.YES_OPTION) {
                    // Delete the record
                    fileDatabaseManagerPlayerGame.deleteRecord(deletePlayerGameRecord);

                    // Reload page to refresh the table
                    displayPlayerGameList();

                    jLabel_PlayerGameDeleteMessage.setText("Entry successfully deleted");
                    jLabel_PlayerGameDeleteMessage.setForeground(Color.BLUE);
                } else {
                    jLabel_PlayerGameDeleteMessage.setText("");
                }
            } else {
                jLabel_PlayerGameDeleteMessage.setText("You need to select one record first");
                jLabel_PlayerGameDeleteMessage.setForeground(Color.RED);
            }
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(BasketManagerJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BasketManagerJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void addMatch() throws IllegalArgumentException {
        String tmpSeasonData = jComboBox_MatchSeasonName.getSelectedItem().toString();
        String[] tmpSeasonIdAndName = splitIdAndName(tmpSeasonData);
        int SeasonId = Integer.parseInt(tmpSeasonIdAndName[0]); // Convert string to int
        String SeasonName = tmpSeasonIdAndName[1];

        String Opponent = jTextField_MatchOpponent.getText().trim();
        Date tmpDate = (Date) jSpinner_MatchDate.getValue();
        long DateTimestamp = tmpDate.getTime();
        String FoulsCommitted = jTextField_MatchFoulsCommitted.getText().trim();
        String FoulsConceded = jTextField_MatchFoulsConceded.getText().trim();
        String Assists = jTextField_MatchAssists.getText().trim();
        String Rebounds = jTextField_MatchRebounds.getText().trim();
        String Steals = jTextField_MatchSteals.getText().trim();
        String Blocks = jTextField_MatchBlocks.getText().trim();
        int HomeGame = jCheckBox_MatchHomeGame.isSelected() ? 1 : 0; // 0 = false or 1 = true
        String PointsScored = jTextField_MatchPointsScored.getText().trim();
        String PointsConceded = jTextField_MatchPointsConceded.getText().trim();
        String Location = jTextField_MatchLocation.getText().trim();
        int IsDeleted = 0; // not deleted

        if (!Opponent.equals("") && !FoulsCommitted.equals("") && !FoulsConceded.equals("") && !Assists.equals("")
                && !Rebounds.equals("") && !Steals.equals("") && !Blocks.equals("")
                && !PointsScored.equals("") && !PointsConceded.equals("") && !Location.equals("")) {

            try {
                FileDatabaseManagerMatch fileDatabaseManagerMatch = new FileDatabaseManagerMatch();
                MatchRecord newMatchRecord = new MatchRecord(DatabaseManager.generateNewEntryId(GlobalVariables.pathMatchesRaf), SeasonId, SeasonName, Opponent, DateTimestamp, FoulsCommitted, FoulsConceded, Assists, Rebounds, Steals, Blocks, HomeGame, PointsScored, PointsConceded, Location, IsDeleted);
                fileDatabaseManagerMatch.insertRecord(newMatchRecord);
            } catch (IOException ex) {
                Logger.getLogger(BasketManagerJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

            clearAddMatch();

            boolean hasSeasons = loadAllSeasonsForMatchAdd();

            boolean enableAddPlayerGameButton = hasSeasons;

            jButton_AddMatch.setEnabled(enableAddPlayerGameButton);

            jLabel_MatchAddMessage.setText("Match added successfully");
            jLabel_MatchAddMessage.setForeground(Color.BLUE);
        } else {
            jLabel_MatchAddMessage.setText("All fields should be filled!");
            jLabel_MatchAddMessage.setForeground(Color.RED);
        }
    }

    private void updateMatch() throws IllegalArgumentException {
        int Id = Integer.parseInt(jLabel_MatchUpdateId.getText());
        int SeasonId = Integer.parseInt(jLabel_MatchUpdateSeasonId.getText());
        String SeasonName = jLabel_MatchUpdateSeasonName.getText();
        String Opponent = jTextField_MatchUpdateOpponent.getText().trim();
        Date tmpDate = (Date) jSpinner_MatchUpdateDate.getValue();
        long DateTimestamp = tmpDate.getTime();
        String FoulsCommitted = jTextField_MatchUpdateFoulsCommitted.getText().trim();
        String FoulsConceded = jTextField_MatchUpdateFoulsConceded.getText().trim();
        String Assists = jTextField_MatchUpdateAssists.getText().trim();
        String Rebounds = jTextField_MatchUpdateRebounds.getText().trim();
        String Steals = jTextField_MatchUpdateSteals.getText().trim();
        String Blocks = jTextField_MatchUpdateBlocks.getText().trim();
        int HomeGame = jCheckBox_MatchUpdateHomeGame.isSelected() ? 1 : 0; // 0 = false or 1 = true
        String PointsScored = jTextField_MatchUpdatePointsScored.getText().trim();
        String PointsConceded = jTextField_MatchUpdatePointsConceded.getText().trim();
        String Location = jTextField_MatchUpdateLocation.getText().trim();
        int IsDeleted = 0; // not deleted

        if (!Opponent.equals("") && !FoulsCommitted.equals("") && !FoulsConceded.equals("") && !Assists.equals("")
                && !Rebounds.equals("") && !Steals.equals("") && !Blocks.equals("")
                && !PointsScored.equals("") && !PointsConceded.equals("") && !Location.equals("")) {

            try {
                FileDatabaseManagerMatch fileDatabaseManagerMatch = new FileDatabaseManagerMatch();

                MatchRecord updateMatchRecord = new MatchRecord(Id, SeasonId, SeasonName, Opponent, DateTimestamp, FoulsCommitted, FoulsConceded, Assists, Rebounds, Steals, Blocks, HomeGame, PointsScored, PointsConceded, Location, IsDeleted);

                fileDatabaseManagerMatch.updateRecord(updateMatchRecord);
            } catch (IOException ex) {
                Logger.getLogger(BasketManagerJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

            jLabel_MatchUpdateMessage.setText("Match added successfully");
            jLabel_MatchUpdateMessage.setForeground(Color.BLUE);

            clearUpdateMatch();

            displayMatchList();
        } else {
            jLabel_MatchUpdateMessage.setText("All fields should be filled!");
            jLabel_MatchUpdateMessage.setForeground(Color.RED);
        }
    }

    private void deleteMatch() {
        try {
            int selectedRow = jTable_MatchesList.getSelectedRow();
            // -1 is the response when none of the rows are selected
            if (selectedRow != -1) {
                int MatchId = Integer.parseInt(jTable_MatchesList.getValueAt(selectedRow, 0).toString());;

                FileDatabaseManagerMatch fileDatabaseManagerMatch = new FileDatabaseManagerMatch();

                // Get the match record
                MatchRecord deleteMatchRecord = (MatchRecord) fileDatabaseManagerMatch.getRecord(MatchId);
                deleteMatchRecord.setIsDeleted(1); // set flag to 1 

                int deleteConfirmation = JOptionPane.showConfirmDialog(jPanel_Main, "Are you sure that you want to delete this match?", "Delete Match", JOptionPane.YES_NO_OPTION);
                if (deleteConfirmation == JOptionPane.YES_OPTION) {
                    // Delete the record
                    fileDatabaseManagerMatch.deleteRecord(deleteMatchRecord);

                    // Reload page to refresh the table
                    displayMatchList();

                    jLabel_MatchDeleteMessage.setText("Entry successfully deleted");
                    jLabel_MatchDeleteMessage.setForeground(Color.BLUE);
                } else {
                    jLabel_MatchDeleteMessage.setText("");
                }
            } else {
                jLabel_MatchDeleteMessage.setText("You need to select one record first");
                jLabel_MatchDeleteMessage.setForeground(Color.RED);
            }
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(BasketManagerJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BasketManagerJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void addSeason() throws IllegalArgumentException {
        String SeasonName = jTextField_SeasonName.getText().trim();

        if (!SeasonName.equals("")) {

            try {
                FileDatabaseManagerSeason fileDatabaseManagerSeason = new FileDatabaseManagerSeason();

                SeasonRecord newSeasonRecord = new SeasonRecord(DatabaseManager.generateNewEntryId(GlobalVariables.pathSeasonsRaf), SeasonName);

                fileDatabaseManagerSeason.insertRecord(newSeasonRecord);
            } catch (IOException ex) {
                Logger.getLogger(BasketManagerJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

            jLabel_SeasonAddMessage.setText("Season added successfully");
            jLabel_SeasonAddMessage.setForeground(Color.BLUE);

            clearAddSeason();
        } else {
            jLabel_SeasonAddMessage.setText("All fields should be filled!");
            jLabel_SeasonAddMessage.setForeground(Color.RED);
        }
    }

    // =====================================================================================
    // Get all available players and add them in the combo box of PlayerGame form
    private boolean loadAllPlayersForPlayerGameAdd() {
        boolean hasPlayers = false;

        ArrayList<PlayerRecord> allPlayers = DatabaseManager.getAllPlayerEntries();

        // Check if there are any players in the database
        if (allPlayers.size() > 0) {
            DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) jComboBox_PlayerGamePlayerName.getModel();
            comboBoxModel.removeAllElements();
            for (PlayerRecord player : allPlayers) {

                String comboBoxItemFormat = player.getId() + "." + player.getFirstName().trim() + " " + player.getLastName().trim();

                comboBoxModel.addElement(comboBoxItemFormat);
            }

            hasPlayers = true;
        } else {
            jLabel_PlayerGameAddMessage.setText("There is no available player to add game stats!");
            jLabel_PlayerGameAddMessage.setForeground(Color.RED);

            hasPlayers = false;
        }

        return hasPlayers;
    }

    // Get all available players and add them in the combo box of PlayerGame form
    private boolean loadAllSeasonsForPlayerGameAdd() {
        boolean hasSeasons = false;

        try {
            ArrayList<SeasonRecord> allSeasons = DatabaseManager.getAllSeasonEntries();

            // Check if there are any players in the database
            if (allSeasons.size() > 0) {
                DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) jComboBox_PlayerGameSeasonName.getModel();
                comboBoxModel.removeAllElements();
                for (SeasonRecord season : allSeasons) {

                    String comboBoxItemFormat = season.getId() + "." + season.getSeasonName().trim();

                    comboBoxModel.addElement(comboBoxItemFormat);
                }

                hasSeasons = true;
            } else {
                jLabel_PlayerGameAddMessage.setText("There is no available season to add game stats!");
                jLabel_PlayerGameAddMessage.setForeground(Color.RED);

                hasSeasons = false;
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(BasketManagerJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        return hasSeasons;
    }

    private boolean loadAllSeasonsForMatchAdd() {
        boolean hasSeasons = false;

        try {
            ArrayList<SeasonRecord> allSeasons = DatabaseManager.getAllSeasonEntries();

            // Check if there are any players in the database
            if (allSeasons.size() > 0) {
                DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) jComboBox_MatchSeasonName.getModel();

                comboBoxModel.removeAllElements();

                for (SeasonRecord season : allSeasons) {

                    String comboBoxItemFormat = season.getId() + "." + season.getSeasonName().trim();

                    comboBoxModel.addElement(comboBoxItemFormat);
                }

                hasSeasons = true;
            } else {
                jLabel_MatchAddMessage.setText("There is no available season to add game stats!");
                jLabel_MatchAddMessage.setForeground(Color.RED);

                hasSeasons = false;
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(BasketManagerJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        return hasSeasons;
    }

    private boolean loadAllPlayersForStatsSingleSeasonPlayer() {
        boolean hasPlayers = false;

        ArrayList<PlayerRecord> allPlayers = DatabaseManager.getAllPlayerEntries();

        // Check if there are any players in the database
        if (allPlayers.size() > 0) {
            DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) jComboBox_StatsSingleSeasonPlayerPlayers.getModel();
            comboBoxModel.removeAllElements();
            for (PlayerRecord player : allPlayers) {

                String comboBoxItemFormat = player.getId() + "." + player.getFirstName().trim() + " " + player.getLastName().trim();

                comboBoxModel.addElement(comboBoxItemFormat);
            }

            hasPlayers = true;
        } else {
            jLabel_StatsSingleSeasonPlayerMessage.setText("There is no available players!");
            jLabel_StatsSingleSeasonPlayerMessage.setForeground(Color.RED);

            hasPlayers = false;
        }

        return hasPlayers;
    }

    // Get all available players and add them in the combo box of PlayerGame form
    private boolean loadAllSeasonsForStatsSingleSeasonPlayer() {
        boolean hasSeasons = false;

        try {
            ArrayList<SeasonRecord> allSeasons = DatabaseManager.getAllSeasonEntries();

            // Check if there are any players in the database
            if (allSeasons.size() > 0) {
                DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) jComboBox_StatsSingleSeasonPlayerSeasons.getModel();
                comboBoxModel.removeAllElements();
                for (SeasonRecord season : allSeasons) {

                    String comboBoxItemFormat = season.getId() + "." + season.getSeasonName().trim();

                    comboBoxModel.addElement(comboBoxItemFormat);
                }

                hasSeasons = true;
            } else {
                jLabel_StatsSingleSeasonPlayerMessage.setText("There is no available seasons!");
                jLabel_StatsSingleSeasonPlayerMessage.setForeground(Color.RED);

                hasSeasons = false;
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(BasketManagerJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        return hasSeasons;
    }

    private boolean loadAllSeasonsForStatsSingleSeasonTeam() {
        boolean hasSeasons = false;

        try {
            ArrayList<SeasonRecord> allSeasons = DatabaseManager.getAllSeasonEntries();

            // Check if there are any players in the database
            if (allSeasons.size() > 0) {
                DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) jComboBox_StatsSingleSeasonTeamSeasons.getModel();
                comboBoxModel.removeAllElements();
                for (SeasonRecord season : allSeasons) {

                    String comboBoxItemFormat = season.getId() + "." + season.getSeasonName().trim();

                    comboBoxModel.addElement(comboBoxItemFormat);
                }

                hasSeasons = true;
            } else {
                jLabel_StatsSingleSeasonTeamMessage.setText("There is no available seasons!");
                jLabel_StatsSingleSeasonTeamMessage.setForeground(Color.RED);

                hasSeasons = false;
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(BasketManagerJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        return hasSeasons;
    }

    private boolean loadAllPlayersForStatsMultipleSeasonsPlayer() {
        boolean hasPlayers = false;

        ArrayList<PlayerRecord> allPlayers = DatabaseManager.getAllPlayerEntries();

        // Check if there are any players in the database
        if (allPlayers.size() > 0) {
            DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) jComboBox_StatsMultipleSeasonsPlayerPlayers.getModel();
            comboBoxModel.removeAllElements();
            for (PlayerRecord player : allPlayers) {

                String comboBoxItemFormat = player.getId() + "." + player.getFirstName().trim() + " " + player.getLastName().trim();

                comboBoxModel.addElement(comboBoxItemFormat);
            }

            hasPlayers = true;
        } else {
            jLabel_StatsMultipleSeasonsPlayerMessage.setText("There is no available players!");
            jLabel_StatsMultipleSeasonsPlayerMessage.setForeground(Color.RED);

            hasPlayers = false;
        }

        return hasPlayers;
    }
    
    private boolean loadAllSeasonsForStatsMultipleSeasonsPlayer() {
        boolean hasSeasons = false;

        try {
            ArrayList<SeasonRecord> allSeasons = DatabaseManager.getAllSeasonEntries();

            // Check if there are any players in the database
            if (allSeasons.size() > 0) {
                DefaultListModel listModel = new DefaultListModel();
                listModel.removeAllElements();
                for (SeasonRecord season : allSeasons) {

                    String listItemFormat = season.getId() + "." + season.getSeasonName().trim();

                    listModel.addElement(listItemFormat);
                }
                
                jList_StatsMultipleSeasonsPlayerSeasons.setModel(listModel);
                
                hasSeasons = true;
            } else {
                jLabel_StatsMultipleSeasonsPlayerMessage.setText("There is no available seasons!");
                jLabel_StatsMultipleSeasonsPlayerMessage.setForeground(Color.RED);

                hasSeasons = false;
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(BasketManagerJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        return hasSeasons;
    }
    
    private boolean loadAllSeasonsForStatsMultipleSeasonsTeam() {
        boolean hasSeasons = false;

        try {
            ArrayList<SeasonRecord> allSeasons = DatabaseManager.getAllSeasonEntries();

            // Check if there are any players in the database
            if (allSeasons.size() > 0) {
                DefaultListModel listModel = new DefaultListModel();
                listModel.removeAllElements();
                for (SeasonRecord season : allSeasons) {

                    String listItemFormat = season.getId() + "." + season.getSeasonName().trim();

                    listModel.addElement(listItemFormat);
                }
                
                jList_StatsMultipleSeasonsTeamSeasons.setModel(listModel);
                
                hasSeasons = true;
            } else {
                jLabel_StatsMultipleSeasonsTeamMessage.setText("There is no available seasons!");
                jLabel_StatsMultipleSeasonsTeamMessage.setForeground(Color.RED);

                hasSeasons = false;
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(BasketManagerJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        return hasSeasons;
    }
    
    // =====================================================================================
    // Calcualate Stats 
    private void calculateStatSingleSeasonPlayer() throws NumberFormatException {
        jLabel_StatsSingleSeasonPlayerAverPointsScored.setText("");
        jLabel_StatsSingleSeasonPlayerAverRebounds.setText("");
        jLabel_StatsSingleSeasonPlayerAverAssists.setText("");

        String tmpPlayerData = jComboBox_StatsSingleSeasonPlayerPlayers.getSelectedItem().toString();
        String[] tmpIdAndName = splitIdAndName(tmpPlayerData);
        int PlayerId = Integer.parseInt(tmpIdAndName[0]); // Convert string to int

        String tmpSeasonData = jComboBox_StatsSingleSeasonPlayerSeasons.getSelectedItem().toString();
        String[] tmpSeasonIdAndName = splitIdAndName(tmpSeasonData);
        int SeasonId = Integer.parseInt(tmpSeasonIdAndName[0]); // Convert string to int

        ArrayList<PlayerGameRecord> playerGameRecords = DatabaseManager.getAllPlayerGamesEntriesOfPlayerSpecificSeason(PlayerId, SeasonId);
        int numOfGames = playerGameRecords.size();
        int sumPointsScored = 0;
        int sumRebounds = 0;
        int sumAssists = 0;
        for (PlayerGameRecord playerGameRecord : playerGameRecords) {
            sumPointsScored += Integer.parseInt(playerGameRecord.getPointsScored().trim());
            sumRebounds += Integer.parseInt(playerGameRecord.getRebounds().trim());
            sumAssists += Integer.parseInt(playerGameRecord.getAssists().trim());
        }

        // Needs to cast the integers to double in order to get the full result
        double averPointsScored = (double) sumPointsScored / (double) numOfGames;
        String tmpAvPointsScored = formatDecimal(averPointsScored);
        jLabel_StatsSingleSeasonPlayerAverPointsScored.setText(tmpAvPointsScored);

        double averRebounds = (double) sumRebounds / (double) numOfGames;
        String tmpAvRebounds = formatDecimal(averRebounds);
        jLabel_StatsSingleSeasonPlayerAverRebounds.setText(tmpAvRebounds);

        double averAssists = (double) sumAssists / (double) numOfGames;
        String tmpAvAssists = formatDecimal(averAssists);
        jLabel_StatsSingleSeasonPlayerAverAssists.setText(tmpAvAssists);        
    }

    private void calculateStatSingleSeasonTeam() throws NumberFormatException {
        jLabel_StatsSingleSeasonTeamAverPointsScored.setText("");
        jLabel_StatsSingleSeasonTeamAverPointsConceded.setText("");

        String tmpSeasonData = jComboBox_StatsSingleSeasonTeamSeasons.getSelectedItem().toString();
        String[] tmpSeasonIdAndName = splitIdAndName(tmpSeasonData);
        int SeasonId = Integer.parseInt(tmpSeasonIdAndName[0]); // Convert string to int

        ArrayList<MatchRecord> matchRecords = DatabaseManager.getAllMatchesEntriesSpecificSeason(SeasonId);

        int numOMatches = matchRecords.size();
        int sumPointsScored = 0;
        int sumPointsConceded = 0;

        for (MatchRecord matchRecord : matchRecords) {
            sumPointsScored += Integer.parseInt(matchRecord.getPointsScored().trim());
            sumPointsConceded += Integer.parseInt(matchRecord.getPointsConceded().trim());
        }

        // Needs to cast the integers to double in order to get the full result
        double averPointsScored = (double) sumPointsScored / (double) numOMatches;
        String tmpAvPointsScored = formatDecimal(averPointsScored);
        jLabel_StatsSingleSeasonTeamAverPointsScored.setText(tmpAvPointsScored);

        double averPointsConceded = (double) sumPointsConceded / (double) numOMatches;
        String tmpAvPointsConceded = formatDecimal(averPointsConceded);
        jLabel_StatsSingleSeasonTeamAverPointsConceded.setText(tmpAvPointsConceded);
    }

    private void calculateStatMultipleSeasonsPlayer() throws NumberFormatException {
        jLabel_StatsMultipleSeasonsPlayerMessage.setText("");
        jLabel_StatsMultipleSeasonsPlayerAverPointsScored.setText("");
        jLabel_StatsMultipleSeasonsPlayerAverRebounds.setText("");
        jLabel_StatsMultipleSeasonsPlayerAverAssists.setText("");

        String tmpPlayerData = jComboBox_StatsMultipleSeasonsPlayerPlayers.getSelectedItem().toString();
        String[] tmpIdAndName = splitIdAndName(tmpPlayerData);
        int PlayerId = Integer.parseInt(tmpIdAndName[0]); // Convert string to int

        // Check if the user has selected any Season entry
        ArrayList<Integer> SelectedSeasonsIdList = new ArrayList();
        if(jList_StatsMultipleSeasonsPlayerSeasons.getSelectedValuesList() == Collections.EMPTY_LIST) {
            jLabel_StatsMultipleSeasonsPlayerMessage.setText("You need to select at least one season!");
            jLabel_StatsMultipleSeasonsPlayerMessage.setForeground(Color.RED);
            return;
        }
        ArrayList<String> tmpSelectedSeasonsList =(ArrayList) jList_StatsMultipleSeasonsPlayerSeasons.getSelectedValuesList();
        for (String seasonData : tmpSelectedSeasonsList) {
            String[] tmpSeasonIdAndName = splitIdAndName(seasonData);
            int tmpSeasonId = Integer.parseInt(tmpSeasonIdAndName[0]); // Convert string to int
            SelectedSeasonsIdList.add(tmpSeasonId);
        }
        
        ArrayList<PlayerGameRecord> playerGameRecords = DatabaseManager.getAllPlayerGamesEntriesOfPlayerAllSelectedSeasons(PlayerId, SelectedSeasonsIdList);
        
        int numOfGames = playerGameRecords.size();
        int sumPointsScored = 0;
        int sumRebounds = 0;
        int sumAssists = 0;
        for (PlayerGameRecord playerGameRecord : playerGameRecords) {
            sumPointsScored += Integer.parseInt(playerGameRecord.getPointsScored().trim());
            sumRebounds += Integer.parseInt(playerGameRecord.getRebounds().trim());
            sumAssists += Integer.parseInt(playerGameRecord.getAssists().trim());
        }

        // Needs to cast the integers to double in order to get the full result
        double averPointsScored = (double) sumPointsScored / (double) numOfGames;
        String tmpAvPointsScored = formatDecimal(averPointsScored);
        jLabel_StatsMultipleSeasonsPlayerAverPointsScored.setText(tmpAvPointsScored);

        double averRebounds = (double) sumRebounds / (double) numOfGames;
        String tmpAvRebounds = formatDecimal(averRebounds);
        jLabel_StatsMultipleSeasonsPlayerAverRebounds.setText(tmpAvRebounds);

        double averAssists = (double) sumAssists / (double) numOfGames;
        String tmpAvAssists = formatDecimal(averAssists);
        jLabel_StatsMultipleSeasonsPlayerAverAssists.setText(tmpAvAssists);
    }

    private void calculateStatMultipleSeasonsTeam() throws NumberFormatException {
        jLabel_StatsMultipleSeasonsTeamMessage.setText("");
        jLabel_StatsMultipleSeasonsTeamAverPointsScored.setText("");
        jLabel_StatsMultipleSeasonsTeamAverPointsConceded.setText("");
        
        // Check if the user has selected any Season entry
        ArrayList<Integer> SelectedSeasonsIdList = new ArrayList();
        if(jList_StatsMultipleSeasonsTeamSeasons.getSelectedValuesList() == Collections.EMPTY_LIST) {
            jLabel_StatsMultipleSeasonsTeamMessage.setText("You need to select at least one season!");
            jLabel_StatsMultipleSeasonsTeamMessage.setForeground(Color.RED);
            return;
        }
        ArrayList<String> tmpSelectedSeasonsList =(ArrayList) jList_StatsMultipleSeasonsTeamSeasons.getSelectedValuesList();
        for (String seasonData : tmpSelectedSeasonsList) {
            String[] tmpSeasonIdAndName = splitIdAndName(seasonData);
            int tmpSeasonId = Integer.parseInt(tmpSeasonIdAndName[0]); // Convert string to int
            SelectedSeasonsIdList.add(tmpSeasonId);
        }
        
        ArrayList<MatchRecord> matchRecords = DatabaseManager.getAllMatchesEntriesOfAllSelectedSeasons(SelectedSeasonsIdList);
        
        int numOfMatches = matchRecords.size();
        int sumPointsScored = 0;
        int sumPointsConceded = 0;
        for (MatchRecord matchRecord : matchRecords) {
            sumPointsScored += Integer.parseInt(matchRecord.getPointsScored().trim());
            sumPointsConceded += Integer.parseInt(matchRecord.getPointsConceded().trim());
        }

        // Needs to cast the integers to double in order to get the full result
        double averPointsScored = (double) sumPointsScored / (double) numOfMatches;
        String tmpAvPointsScored = formatDecimal(averPointsScored);
        jLabel_StatsMultipleSeasonsTeamAverPointsScored.setText(tmpAvPointsScored);
        
        double averPointsConceded = (double) sumPointsConceded / (double) numOfMatches;
        String tmpAvPointsConceded = formatDecimal(averPointsConceded);
        jLabel_StatsMultipleSeasonsTeamAverPointsConceded.setText(tmpAvPointsConceded);
    }
    
    private String formatDecimal(Double inputString) {
        String pattern = "#.##"; // Show up to 2 decimals
        
        DecimalFormat myFormatter = new DecimalFormat(pattern);
        
        String formattedString = myFormatter.format(inputString);
        
        return formattedString;
    }
    
    // =====================================================================================
    // Clear forms
    private void clearAddPlayer() {
        jTextField_PlayerFirstName.setText("");
        jTextField_PlayerLastName.setText("");
        jTextField_PlayerDoB.setText("");
        jTextField_PlayerPoB.setText("");
        jTextField_PlayerHeight.setText("");
        jTextField_PlayerWeight.setText("");
        jTextField_PlayerPosition.setText("");
        jTextField_PlayerJersey.setText("");
    }

    private void clearUpdatePlayer() {
        jTextField_PlayerUpdateFirstName.setText("");
        jTextField_PlayerUpdateLastName.setText("");
        jTextField_PlayerUpdateDoB.setText("");
        jTextField_PlayerUpdatePoB.setText("");
        jTextField_PlayerUpdateHeight.setText("");
        jTextField_PlayerUpdateWeight.setText("");
        jTextField_PlayerUpdatePosition.setText("");
        jTextField_PlayerUpdateJersey.setText("");
    }

    private long getCurrentTimestamp() {
        //If you want the current timestamp :
        Calendar c = Calendar.getInstance();
        long timestamp = c.getTimeInMillis();

        return timestamp;
    }

    private void clearAddMatch() {
        jTextField_MatchOpponent.setText("");
        jSpinner_MatchDate.setValue(new Date(getCurrentTimestamp()));
        jTextField_MatchFoulsCommitted.setText("");
        jTextField_MatchFoulsConceded.setText("");
        jTextField_MatchAssists.setText("");
        jTextField_MatchRebounds.setText("");
        jTextField_MatchSteals.setText("");
        jTextField_MatchBlocks.setText("");
        jCheckBox_MatchHomeGame.setSelected(false);
        jTextField_MatchPointsScored.setText("");
        jTextField_MatchPointsConceded.setText("");
        jTextField_MatchLocation.setText("");

        jLabel_MatchAddMessage.setText("");
    }

    private void clearUpdateMatch() {
        jTextField_MatchUpdateOpponent.setText("");
        jSpinner_MatchUpdateDate.setValue(new Date(getCurrentTimestamp()));
        jTextField_MatchUpdateFoulsCommitted.setText("");
        jTextField_MatchUpdateFoulsConceded.setText("");
        jTextField_MatchUpdateAssists.setText("");
        jTextField_MatchUpdateRebounds.setText("");
        jTextField_MatchUpdateSteals.setText("");
        jTextField_MatchUpdateBlocks.setText("");
        jCheckBox_MatchUpdateHomeGame.setSelected(false);
        jTextField_MatchUpdatePointsScored.setText("");
        jTextField_MatchUpdatePointsConceded.setText("");
        jTextField_MatchUpdateLocation.setText("");

        jLabel_MatchUpdateMessage.setText("");
    }

    private void clearAddPlayerGame() {
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) jComboBox_PlayerGameSeasonName.getModel();
        comboBoxModel.removeAllElements();

        comboBoxModel = (DefaultComboBoxModel) jComboBox_PlayerGamePlayerName.getModel();
        comboBoxModel.removeAllElements();

        jTextField_PlayerGameFoulsCommitted.setText("");
        jTextField_PlayerGameFoulsConceded.setText("");
        jTextField_PlayerGameAssists.setText("");
        jTextField_PlayerGameRebounds.setText("");
        jTextField_PlayerGameSteals.setText("");
        jTextField_PlayerGameBlocks.setText("");
        jCheckBox_PlayerGameHomeGame.setSelected(false);
        jTextField_PlayerGameAwayTeamName.setText("");
        jTextField_PlayerGamePointsScored.setText("");
        jTextField_PlayerGameLocation.setText("");
        jSpinner_PlayerGameDate.setValue(new Date(getCurrentTimestamp()));

    }

    private void clearAddSeason() {
        jTextField_SeasonName.setText("");
    }

    private void clearStatsSingleSeasonPlayer() {
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) jComboBox_StatsSingleSeasonPlayerPlayers.getModel();
        comboBoxModel.removeAllElements();
        comboBoxModel = (DefaultComboBoxModel) jComboBox_StatsSingleSeasonPlayerSeasons.getModel();
        comboBoxModel.removeAllElements();

        jLabel_StatsSingleSeasonPlayerAverPointsScored.setText("");
        jLabel_StatsSingleSeasonPlayerAverRebounds.setText("");
        jLabel_StatsSingleSeasonPlayerAverAssists.setText("");
    }

    private void clearStatsSingleSeasonTeam() {
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) jComboBox_StatsSingleSeasonTeamSeasons.getModel();
        comboBoxModel.removeAllElements();

        jLabel_StatsSingleSeasonTeamAverPointsScored.setText("");
        jLabel_StatsSingleSeasonTeamAverPointsConceded.setText("");
    }
    
    private void clearStatsMultipleSeasonsPlayer() {
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) jComboBox_StatsMultipleSeasonsPlayerPlayers.getModel();
        comboBoxModel.removeAllElements();
        
        jList_StatsMultipleSeasonsPlayerSeasons.setModel(new DefaultListModel());
        
        jLabel_StatsMultipleSeasonsPlayerAverPointsScored.setText("");
        jLabel_StatsMultipleSeasonsPlayerAverRebounds.setText("");
        jLabel_StatsMultipleSeasonsPlayerAverAssists.setText("");
    }
    
    private void clearStatsMultipleSeasonsTeam() {
        jList_StatsMultipleSeasonsTeamSeasons.setModel(new DefaultListModel());
        
        jLabel_StatsMultipleSeasonsTeamAverPointsScored.setText("");
        jLabel_StatsMultipleSeasonsTeamAverPointsConceded.setText("");
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BasketManagerJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BasketManagerJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BasketManagerJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BasketManagerJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BasketManagerJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_AddMatch;
    private javax.swing.JButton jButton_AddPlayer;
    private javax.swing.JButton jButton_AddPlayer1;
    private javax.swing.JButton jButton_AddPlayerGame;
    private javax.swing.JButton jButton_DeleteMatch;
    private javax.swing.JButton jButton_DeletePlayer;
    private javax.swing.JButton jButton_DeletePlayerGame;
    private javax.swing.JButton jButton_ShowStatsMultipleSeasonsPlayer;
    private javax.swing.JButton jButton_ShowStatsMultipleSeasonsTeam;
    private javax.swing.JButton jButton_ShowStatsSingleSeasonPlayer;
    private javax.swing.JButton jButton_ShowStatsSingleSeasonTeam;
    private javax.swing.JButton jButton_UpdateMatch;
    private javax.swing.JButton jButton_UpdateMatchCancel;
    private javax.swing.JButton jButton_UpdatePlayer;
    private javax.swing.JButton jButton_UpdatePlayerCancel;
    private javax.swing.JButton jButton_UpdatePlayerGame;
    private javax.swing.JButton jButton_UpdatePlayerGameCancel;
    private javax.swing.JCheckBox jCheckBox_MatchHomeGame;
    private javax.swing.JCheckBox jCheckBox_MatchUpdateHomeGame;
    private javax.swing.JCheckBox jCheckBox_PlayerGameHomeGame;
    private javax.swing.JCheckBox jCheckBox_PlayerGameUpdateHomeGame;
    private javax.swing.JComboBox<String> jComboBox_MatchSeasonName;
    private javax.swing.JComboBox<String> jComboBox_PlayerGamePlayerName;
    private javax.swing.JComboBox<String> jComboBox_PlayerGameSeasonName;
    private javax.swing.JComboBox<String> jComboBox_StatsMultipleSeasonsPlayerPlayers;
    private javax.swing.JComboBox<String> jComboBox_StatsSingleSeasonPlayerPlayers;
    private javax.swing.JComboBox<String> jComboBox_StatsSingleSeasonPlayerSeasons;
    private javax.swing.JComboBox<String> jComboBox_StatsSingleSeasonTeamSeasons;
    private javax.swing.JFileChooser jFileChooser_ImportExcel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_MatchAddMessage;
    private javax.swing.JLabel jLabel_MatchDeleteMessage;
    private javax.swing.JLabel jLabel_MatchUpdateId;
    private javax.swing.JLabel jLabel_MatchUpdateMessage;
    private javax.swing.JLabel jLabel_MatchUpdateSeasonId;
    private javax.swing.JLabel jLabel_MatchUpdateSeasonName;
    private javax.swing.JLabel jLabel_PlayerAddMessage;
    private javax.swing.JLabel jLabel_PlayerDeleteMessage;
    private javax.swing.JLabel jLabel_PlayerGameAddMessage;
    private javax.swing.JLabel jLabel_PlayerGameDeleteMessage;
    private javax.swing.JLabel jLabel_PlayerGameUpdateGameId;
    private javax.swing.JLabel jLabel_PlayerGameUpdateMessage;
    private javax.swing.JLabel jLabel_PlayerGameUpdatePlayerId;
    private javax.swing.JLabel jLabel_PlayerGameUpdatePlayerName;
    private javax.swing.JLabel jLabel_PlayerGameUpdateSeasonId;
    private javax.swing.JLabel jLabel_PlayerGameUpdateSeasonName;
    private javax.swing.JLabel jLabel_PlayerUpdateId;
    private javax.swing.JLabel jLabel_PlayerUpdateMessage;
    private javax.swing.JLabel jLabel_SeasonAddMessage;
    private javax.swing.JLabel jLabel_StatsMultipleSeasonsPlayerAverAssists;
    private javax.swing.JLabel jLabel_StatsMultipleSeasonsPlayerAverPointsScored;
    private javax.swing.JLabel jLabel_StatsMultipleSeasonsPlayerAverRebounds;
    private javax.swing.JLabel jLabel_StatsMultipleSeasonsPlayerMessage;
    private javax.swing.JLabel jLabel_StatsMultipleSeasonsTeamAverPointsConceded;
    private javax.swing.JLabel jLabel_StatsMultipleSeasonsTeamAverPointsScored;
    private javax.swing.JLabel jLabel_StatsMultipleSeasonsTeamMessage;
    private javax.swing.JLabel jLabel_StatsSingleSeasonPlayerAverAssists;
    private javax.swing.JLabel jLabel_StatsSingleSeasonPlayerAverPointsScored;
    private javax.swing.JLabel jLabel_StatsSingleSeasonPlayerAverRebounds;
    private javax.swing.JLabel jLabel_StatsSingleSeasonPlayerMessage;
    private javax.swing.JLabel jLabel_StatsSingleSeasonTeamAverPointsConceded;
    private javax.swing.JLabel jLabel_StatsSingleSeasonTeamAverPointsScored;
    private javax.swing.JLabel jLabel_StatsSingleSeasonTeamMessage;
    private javax.swing.JList<String> jList_SeasonList;
    private javax.swing.JList<String> jList_StatsMultipleSeasonsPlayerSeasons;
    private javax.swing.JList<String> jList_StatsMultipleSeasonsTeamSeasons;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem_FileExit;
    private javax.swing.JMenuItem jMenuItem_FileImportMatches;
    private javax.swing.JMenuItem jMenuItem_FileImportPlayers;
    private javax.swing.JMenuItem jMenuItem_FileImportPlayersGames;
    private javax.swing.JMenuItem jMenuItem_MatchAddNew;
    private javax.swing.JMenuItem jMenuItem_MatchList;
    private javax.swing.JMenuItem jMenuItem_MultipleSeasonPlayer;
    private javax.swing.JMenuItem jMenuItem_MultipleSeasonTeam;
    private javax.swing.JMenuItem jMenuItem_PlayerAdd;
    private javax.swing.JMenuItem jMenuItem_PlayerAddGame;
    private javax.swing.JMenuItem jMenuItem_PlayerGameList;
    private javax.swing.JMenuItem jMenuItem_PlayerList;
    private javax.swing.JMenuItem jMenuItem_SeasonAddSeason;
    private javax.swing.JMenuItem jMenuItem_SeasonList;
    private javax.swing.JMenuItem jMenuItem_SingleSeasonPlayer;
    private javax.swing.JMenuItem jMenuItem_SingleSeasonTeam;
    private javax.swing.JMenu jMenu_File;
    private javax.swing.JMenu jMenu_MatchData;
    private javax.swing.JMenu jMenu_MultipleSeasons;
    private javax.swing.JMenu jMenu_Player;
    private javax.swing.JMenu jMenu_Season;
    private javax.swing.JMenu jMenu_SingleSeason;
    private javax.swing.JMenu jMenu_Statictis;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanel_Intro;
    private javax.swing.JPanel jPanel_Main;
    private javax.swing.JPanel jPanel_MainBody;
    private javax.swing.JPanel jPanel_MatchAdd;
    private javax.swing.JPanel jPanel_MatchList;
    private javax.swing.JPanel jPanel_MatchUpdate;
    private javax.swing.JPanel jPanel_PlayerAdd;
    private javax.swing.JPanel jPanel_PlayerGameAdd;
    private javax.swing.JPanel jPanel_PlayerGameList;
    private javax.swing.JPanel jPanel_PlayerGameUpdate;
    private javax.swing.JPanel jPanel_PlayerList;
    private javax.swing.JPanel jPanel_PlayerUpdate;
    private javax.swing.JPanel jPanel_SeasonAdd;
    private javax.swing.JPanel jPanel_SeasonList;
    private javax.swing.JPanel jPanel_StatsMultipleSeasonsPlayer;
    private javax.swing.JPanel jPanel_StatsMultipleSeasonsTeam;
    private javax.swing.JPanel jPanel_StatsSingleSeasonPlayer;
    private javax.swing.JPanel jPanel_StatsSingleSeasonTeam;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSpinner jSpinner_MatchDate;
    private javax.swing.JSpinner jSpinner_MatchUpdateDate;
    private javax.swing.JSpinner jSpinner_PlayerGameDate;
    private javax.swing.JSpinner jSpinner_PlayerGameUpdateDate;
    private javax.swing.JTable jTable_MatchesList;
    private javax.swing.JTable jTable_PlayerGamesList;
    private javax.swing.JTable jTable_PlayersList;
    private javax.swing.JTextField jTextField_MatchAssists;
    private javax.swing.JTextField jTextField_MatchBlocks;
    private javax.swing.JTextField jTextField_MatchFoulsCommitted;
    private javax.swing.JTextField jTextField_MatchFoulsConceded;
    private javax.swing.JTextField jTextField_MatchLocation;
    private javax.swing.JTextField jTextField_MatchOpponent;
    private javax.swing.JTextField jTextField_MatchPointsConceded;
    private javax.swing.JTextField jTextField_MatchPointsScored;
    private javax.swing.JTextField jTextField_MatchRebounds;
    private javax.swing.JTextField jTextField_MatchSteals;
    private javax.swing.JTextField jTextField_MatchUpdateAssists;
    private javax.swing.JTextField jTextField_MatchUpdateBlocks;
    private javax.swing.JTextField jTextField_MatchUpdateFoulsCommitted;
    private javax.swing.JTextField jTextField_MatchUpdateFoulsConceded;
    private javax.swing.JTextField jTextField_MatchUpdateLocation;
    private javax.swing.JTextField jTextField_MatchUpdateOpponent;
    private javax.swing.JTextField jTextField_MatchUpdatePointsConceded;
    private javax.swing.JTextField jTextField_MatchUpdatePointsScored;
    private javax.swing.JTextField jTextField_MatchUpdateRebounds;
    private javax.swing.JTextField jTextField_MatchUpdateSteals;
    private javax.swing.JTextField jTextField_PlayerDoB;
    private javax.swing.JTextField jTextField_PlayerFirstName;
    private javax.swing.JTextField jTextField_PlayerGameAssists;
    private javax.swing.JTextField jTextField_PlayerGameAwayTeamName;
    private javax.swing.JTextField jTextField_PlayerGameBlocks;
    private javax.swing.JTextField jTextField_PlayerGameFoulsCommitted;
    private javax.swing.JTextField jTextField_PlayerGameFoulsConceded;
    private javax.swing.JTextField jTextField_PlayerGameLocation;
    private javax.swing.JTextField jTextField_PlayerGamePointsScored;
    private javax.swing.JTextField jTextField_PlayerGameRebounds;
    private javax.swing.JTextField jTextField_PlayerGameSteals;
    private javax.swing.JTextField jTextField_PlayerGameUpdateAssists;
    private javax.swing.JTextField jTextField_PlayerGameUpdateAwayTeamName;
    private javax.swing.JTextField jTextField_PlayerGameUpdateBlocks;
    private javax.swing.JTextField jTextField_PlayerGameUpdateFoulsCommitted;
    private javax.swing.JTextField jTextField_PlayerGameUpdateFoulsConceded;
    private javax.swing.JTextField jTextField_PlayerGameUpdateLocation;
    private javax.swing.JTextField jTextField_PlayerGameUpdatePointsScored;
    private javax.swing.JTextField jTextField_PlayerGameUpdateRebounds;
    private javax.swing.JTextField jTextField_PlayerGameUpdateSteals;
    private javax.swing.JTextField jTextField_PlayerHeight;
    private javax.swing.JTextField jTextField_PlayerJersey;
    private javax.swing.JTextField jTextField_PlayerLastName;
    private javax.swing.JTextField jTextField_PlayerPoB;
    private javax.swing.JTextField jTextField_PlayerPosition;
    private javax.swing.JTextField jTextField_PlayerUpdateDoB;
    private javax.swing.JTextField jTextField_PlayerUpdateFirstName;
    private javax.swing.JTextField jTextField_PlayerUpdateHeight;
    private javax.swing.JTextField jTextField_PlayerUpdateJersey;
    private javax.swing.JTextField jTextField_PlayerUpdateLastName;
    private javax.swing.JTextField jTextField_PlayerUpdatePoB;
    private javax.swing.JTextField jTextField_PlayerUpdatePosition;
    private javax.swing.JTextField jTextField_PlayerUpdateWeight;
    private javax.swing.JTextField jTextField_PlayerWeight;
    private javax.swing.JTextField jTextField_SeasonName;
    // End of variables declaration//GEN-END:variables

}
