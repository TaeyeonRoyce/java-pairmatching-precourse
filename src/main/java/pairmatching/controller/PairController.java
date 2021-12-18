package pairmatching.controller;

import pairmatching.domains.crew.BackendCrews;
import pairmatching.domains.crew.FrontendCrews;
import pairmatching.domains.mission.Missions;
import pairmatching.domains.programfunc.ProgramSelection;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairController {
	private FrontendCrews frontendCrews;
	private BackendCrews backendCrews;
	private Missions missions;

	public PairController(FrontendCrews frontendCrews, BackendCrews backendCrews,
		Missions missions) {
		this.frontendCrews = frontendCrews;
		this.backendCrews = backendCrews;
		this.missions = missions;
	}

	public void initiate() {
		frontendCrews.setFrontendCrews();
		backendCrews.setBackendCrews();
		missions.loadMission();

		run();
	}

	private void run() {
		try {
			OutputView.printSelection();
			ProgramSelection userSelect = InputView.getUserSelect();
			doSelection(userSelect);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			run();
		}
	}

	private void doSelection(ProgramSelection selection) {
		if (selection == ProgramSelection.MATCHING) {
			matching();
		} else if (selection == ProgramSelection.FIND_ALL) {

		} else if (selection == ProgramSelection.CLEAR) {

		} else if (selection == ProgramSelection.QUIT) {
			return;
		}
		run();
	}

	private void matching() {
		OutputView.printTechCourseState();
	}
}
