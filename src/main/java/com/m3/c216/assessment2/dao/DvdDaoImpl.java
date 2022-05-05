package com.m3.c216.assessment2.dao;

import com.m3.c216.assessment2.dto.DVD;
import java.io.*;
import java.sql.Date;
import java.util.*;


public class DvdDaoImpl implements DvdDao {

    private final Map<String, DVD> dvdMap; //<K = title, V = dvd>
    private Scanner scanner;
    private final String file_path;
    public DvdDaoImpl(String file_path){
        this.file_path=file_path;
        dvdMap = new HashMap<>();
    }

    private DVD unmarshallDVD(String dvdText){
        String[] tokens = dvdText.split("::");
        DVD dvdFromFile;
        try{
            dvdFromFile = new DVD(
                    tokens[0],
                    Date.valueOf(tokens[1]),
                    tokens[2],
                    tokens[3],
                    tokens[4],
                    //Double.parseDouble(tokens[5].split(" ")[0]),
                    Double.parseDouble(tokens[5].split("(?i)(?=[a-z])",1).toString()),
                    tokens[5].split("(?i)(?=[a-z])",2).toString());
        } catch (Exception e){
            System.out.println("ERROR: failed to load file");
            return null;
        }

        return dvdFromFile;
    }

    private String marshallDVD(DVD dvd){
        return String.format("%s::%s::%s::%s::%s::%f %s", // rating and review stored next to each other - requirements
                dvd.getTitle(), dvd.getRelease_date(), dvd.getMpaa(),
                dvd.getDirector(), dvd.getStudio(), dvd.getRating(), dvd.getReview());
    }

    public void loadCollection() throws DvdDaoException {
        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(file_path)));
        } catch (FileNotFoundException e) {
            throw new DvdDaoException(
                    "-_- Could not load DVD Collection into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentStudent holds the most recent student unmarshalled
        DVD currentDvd;
        // Go through ROSTER_FILE line by line, decoding each line into a
        // Student object by calling the unmarshallStudent method.
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // unmarshall the line into a Student
            currentDvd = unmarshallDVD(currentLine);

            // We are going to use the student id as the map key for our student object.
            // Put currentStudent into the map using student id as the key
            dvdMap.put(currentDvd.getTitle(), currentDvd);
        }
        // close scanner
        scanner.close();
    }

    public void writeDVD() throws DvdDaoException {
        // NOTE FOR APPRENTICES: We are not handling the IOException - but
        // we are translating it to an application specific exception and
        // then simple throwing it (i.e. 'reporting' it) to the code that
        // called us.  It is the responsibility of the calling code to
        // handle any errors that occur.
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(file_path));
        } catch (IOException e) {
            throw new DvdDaoException(
                    "Could not save student data.", e);
        }

        String dvdText;
        List<DVD> dvdList = this.getAllDVDs();
        for (DVD currentDVD : dvdList) {

             dvdText = marshallDVD(currentDVD);

            out.println(dvdText);

            out.flush();
        }
        // Clean up
        out.close();
    }

    @Override
    public DVD addDVD(DVD dvd) throws DvdDaoException {
        //throw new UnsupportedOperationException("Not supported yet.");
        loadCollection();
        DVD newDVD = dvdMap.put(dvd.getTitle(), dvd);
        writeDVD();
        return newDVD;
    }

    @Override
    public DVD removeDVD(String title) throws DvdDaoException{
        loadCollection();
        DVD removedDVD = dvdMap.remove(title); //title is key
        writeDVD();
        return removedDVD;
    }

    public DVD getDVD(String title) throws DvdDaoException {
        loadCollection();
        return dvdMap.get(title);
    }

    @Override
    public List<DVD> getAllDVDs() throws DvdDaoException {
        loadCollection();
        return new ArrayList(dvdMap.values());
    }
}
