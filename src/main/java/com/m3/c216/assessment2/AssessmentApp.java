package com.m3.c216.assessment2;

import com.m3.c216.assessment2.controller.Controller;
import com.m3.c216.assessment2.dao.DvdDao;
import com.m3.c216.assessment2.dao.DvdDaoImpl;
import com.m3.c216.assessment2.ui.DvdView;
import com.m3.c216.assessment2.ui.UserIO;
import com.m3.c216.assessment2.ui.UserIOConsoleImpl;

public class AssessmentApp {
    public static final String DVD_FILE = "src/dvd.txt";

    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        DvdView myView = new DvdView(myIo);
        DvdDao myDao = new DvdDaoImpl(DVD_FILE);
        Controller controller = new Controller(myDao, myView);
        controller.run();
    }
}


