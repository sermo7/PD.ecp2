package web.architecture.presentation.presenters;

import rest.business.controllers.BusinessControllerVoting;
import rest.business.views.TransferObjectThemesManager;
import web.architecture.presentation.models.Model;

public class VotingPresenter {

    public String process(Model model) {
        model.put("log", "VotingPresenter:process");
        return "VotingView";
    }

    public String voteTheme(Model model) {
        model.put("log", "VotingPresenter:voteTheme");
        new BusinessControllerVoting().m2(new TransferObjectThemesManager());
        return "VotingView";
    }

    public String showThemeManager(Model model) {
        model.put("log", "ThemesManagerPresenter:showThemeManager");
        new BusinessControllerVoting().m2(new TransferObjectThemesManager());
        return "ThemeManagerView";
    }
}
