package web.architecture.presentation.frontController;

import web.http.HttpRequest;
import web.http.HttpResponse;
import web.architecture.presentation.models.Model;
import web.architecture.presentation.presenters.VotingPresenter;
import web.architecture.presentation.presenters.ThemeManagerPresenter;
import web.architecture.presentation.views.ErrorView;
import web.architecture.presentation.views.ThemeManagerView;
import web.architecture.presentation.views.VotingView;
import web.architecture.presentation.views.View;

public class Dispatcher {

    public void doGet(HttpRequest request, HttpResponse response) {
        Model model = new Model();
        String presenter = request.getPath() + "Presenter";
        String nextView = request.getPath() + "View";

        switch (presenter) {
        case "VotingPresenter":
            VotingPresenter votingPresenter = new VotingPresenter();
            nextView = votingPresenter.process(model);
            break;
        case "ThemeManagerPresenter":
            ThemeManagerPresenter themeManagerPresenter = new ThemeManagerPresenter();
            nextView = themeManagerPresenter.process(model);
            break;
        }
        this.show(nextView, model);
    }

    public void doPost(HttpRequest request, HttpResponse response) {
        Model model = new Model();
        String controller = request.getPath() + "Presenter";
        String action = request.getParams().get("action");
        String nextView = request.getPath() + "View";

        switch (controller) {
        case "VotingPresenter":
            VotingPresenter votingPresenter = new VotingPresenter();
            if ("voteTheme".equals(action)) {
                // TODO uI1Presenter.setters((request.getParams().get("param")));
                nextView = votingPresenter.voteTheme(model);
            } else if ("showThemeManager".equals(action)) {
                // TODO uI1Presenter.setters((request.getParams().get("param")));
                nextView = votingPresenter.showThemeManager(model);
            } else {
                model.put("error", "Acción no permitida: " + action);
            }
            break;
        case "ThemeManagerPresenter":
            ThemeManagerPresenter themeManagerPresenter = new ThemeManagerPresenter();
            if ("createTheme".equals(action)) {
                // TODO uI2Presenter.setters((request.getParams().get("param")));
                nextView = themeManagerPresenter.createTheme(model);
            } else if ("showVoting".equals(action)) {
                // TODO uI1Presenter.setters((request.getParams().get("param")));
                nextView = themeManagerPresenter.ShowVoting(model);
            } else {
                model.put("error", "Acción no permitida: " + action);
            }
            break;
        }
        this.show(nextView, model);
    }

    private void show(String nextView, Model model) {
        View view;
        switch (nextView) {
        case "VotingView":
            view = new VotingView();
            break;
        case "ThemeManagerView":
            view = new ThemeManagerView();
            break;
        default:
            view = new ErrorView();
            model.put("error", "Vista no encontrada: " + nextView);
        }
        view.show(model);
    }

}
