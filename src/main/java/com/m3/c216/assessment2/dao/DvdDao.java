package com.m3.c216.assessment2.dao;

import com.m3.c216.assessment2.dto.DVD;

import java.util.List;

public interface DvdDao{
    public DVD addDVD(DVD dvd) throws DvdDaoException;
    public DVD removeDVD(String title) throws DvdDaoException;
    public DVD getDVD(String title) throws DvdDaoException;
    public List<DVD> getAllDVDs() throws DvdDaoException;
    public void loadCollection() throws DvdDaoException;
    public void writeDVD() throws DvdDaoException;
}
