package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ActivitySevenConfig {
	
	// create Bean for PresenceFortuneService
	@Bean
	public PresenceFortuneService myPresence() {
		return new PresenceFortuneService();
	}
	
	// Inject Bean into MeditaionCoach
	@Bean
	public MeditationCoach meditating() {
		return new MeditationCoach(myPresence());
	}

}
