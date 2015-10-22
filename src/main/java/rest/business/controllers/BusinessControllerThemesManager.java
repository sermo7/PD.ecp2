package rest.business.controllers;

import rest.data.models.daos.DaoFactory;
import rest.business.views.TransferObjectVoting;
import rest.business.views.TransferObjectThemesManager;

public class BusinessControllerThemesManager {

    public TransferObjectThemesManager m1() {
        DaoFactory.getFactory().getVoteDao().findAll();
        return new TransferObjectThemesManager();
    }

    public void m2(TransferObjectVoting transferVoting) {
        DaoFactory.getFactory().getThemeDao().read(1);
    }
}
