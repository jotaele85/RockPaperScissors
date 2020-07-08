package com.codetest.rps.resources;

import com.codetest.rps.models.Game;
import com.codetest.rps.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
@Scope("session")
public class GameController {

    private List<Game> games;

    private GameService gameService;

    /**
     * Parameterized constructor for {@linc GameController}.
     * @param gameService - the {@linc gameService} to set.
     */
    @Autowired
    public GameController(GameService gameService) {
        games = new ArrayList<Game>();
        this.gameService = gameService;
    }

    @Value("${application.controller.title}")
    private String title;

    @Value("${application.controller.welcomeMessage}")
    private String welcome;

    @Value("${application.controller.playerChoice}")
    private String playerChoice;

    @Value("${application.controller.computerChoice}")
    private String computerChoice;

    @Value("${application.controller.result}")
    private String result;

    @Value("${application.controller.playButton}")
    private String playButton;

    @Value("${application.controller.restartButton}")
    private String restartButton;

    @Value("${application.controller.rounds}")
    private String rounds;

    @Value("${application.controller.stats}")
    private String goToStats;

    @Value("${application.controller.statsTitle}")
    private String statsTitle;

    @Value("${application.controller.return}")
    private String ret;

    @Value("${application.controller.computerAcc}")
    private String computerAcc;

    @Value("${application.controller.playerAcc}")
    private String playerAcc;

    @Value("${application.controller.totalAcc}")
    private String totalAcc;

    @Value("${application.controller.drawsAcc}")
    private String drawsAcc;

    @GetMapping("/")
    public String index(ModelMap model) {
        model.addAttribute("title", this.title);
        model.addAttribute("welcome", this.welcome);
        model.addAttribute("playButton", this.playButton);
        model.addAttribute("playerChoice", this.playerChoice);
        model.addAttribute("computerChoice", this.computerChoice);
        model.addAttribute("result", this.result);
        model.addAttribute("restartButton", this.restartButton);
        model.addAttribute("games", this.games);
        model.addAttribute("rounds", this.rounds);
        model.addAttribute("numGames", this.games.size());
        model.addAttribute("gameService", this.gameService);
        model.addAttribute("goToStats", this.goToStats);
        return "index";
    }

    @GetMapping("/play")
    public RedirectView play(RedirectAttributes attributes) throws Exception {
        this.games = gameService.playGame();
        RedirectView redirect = new RedirectView("/");
        return redirect;
    }

    @GetMapping("/restart")
    public RedirectView restart(RedirectAttributes attributes) throws Exception {
        gameService.restartGame();
        RedirectView redirect = new RedirectView("/");
        return redirect;
    }

    @GetMapping("/stats")
    public String stats(ModelMap model) throws Exception {
        model.addAttribute("title", this.title);
        model.addAttribute("statsTitle", this.statsTitle);
        model.addAttribute("computerAcc", this.computerAcc);
        model.addAttribute("playerAcc", this.playerAcc);
        model.addAttribute("totalAcc", this.totalAcc);
        model.addAttribute("drawsAcc", this.drawsAcc);
        model.addAttribute("ret", this.ret);
        model.addAttribute("gameService", this.gameService);
        return "stats";
    }

    @GetMapping("/goBack")
    public RedirectView goBack(RedirectAttributes attributes){
        RedirectView redirect = new RedirectView("/");
        return redirect;
    }
}
