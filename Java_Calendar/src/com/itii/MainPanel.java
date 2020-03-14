package com.itii;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class MainPanel extends JPanel {
    private static final int MENU_SIZE = 4;
    private PanelButton mPanelButton;
    private PanelView mPanelView;
    private ListPanel mListPanel;
    private MonthPanel mMonthPanel;
    private WeekPanel mWeekPanel;
    private String[] choiceList;
    JComboBox<String> mPanelList;
    MainPanel(){
        initComboBox();
        //this.add(mPanelButton);
    }


    private void initComboBox(){
        choiceList = new String[] {"Month","Week","List"};
        mPanelList = new JComboBox<>(choiceList);
        this.add(mPanelList);


    }


}
