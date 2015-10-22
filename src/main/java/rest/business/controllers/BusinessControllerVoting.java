package rest.business.controllers;

import rest.data.models.daos.DaoFactory;
import rest.business.views.TransferObjectVoting;
import rest.business.views.TransferObjectThemesManager;

public class BusinessControllerVoting {

    public TransferObjectVoting m1() {
        DaoFactory.getFactory().getVoteDao().findAll();
        return new TransferObjectVoting();
    }

    public void m2(TransferObjectThemesManager transferThemesManager) {
        DaoFactory.getFactory().getThemeDao().read(1);
    }

}
