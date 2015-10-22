package web.architecture.presentation.presenters;

import rest.business.controllers.BusinessControllerThemesManager;
import rest.business.views.TransferObjectThemesManager;
import web.architecture.presentation.models.Model;

public class ThemeManagerPresenter {

    public String process(Model model) {
        model.put("log", "ThemesManagerPresenter:process");
        return "ThemesManagerView";
    }

    public String createTheme(Model model) {
        model.put("log", "ThemesManagerPresenter:createTheme");
        TransferObjectThemesManager transferObjectThemesManager = new BusinessControllerThemesManager().m1();
        model.put("transferObjectThemesManager", transferObjectThemesManager);
        return "ThemesManagerView";
    }

    public String ShowVoting(Model model) {
        model.put("log", "ThemesManagerPresenter:showVoting");
        TransferObjectThemesManager transferObjectThemesManager = new BusinessControllerThemesManager().m1();
        model.put("transferObjectThemesManager", transferObjectThemesManager);
        return "VotingView";
    }

}
