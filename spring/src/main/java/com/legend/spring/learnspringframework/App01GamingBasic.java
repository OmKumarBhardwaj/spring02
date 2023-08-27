package com.legend.spring.learnspringframework;

import com.legend.spring.game.GameRunner;
import com.legend.spring.game.PacMan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App01GamingBasic {
	public static void main(String[] args) {

//		 var game = new MarioGame();
//		var game = new SuperContra();
		var game = new PacMan();
		var gameRunner = new GameRunner(game);
		gameRunner.run();
	}
}
