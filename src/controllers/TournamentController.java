package controllers;

import models.Tournament;

public class TournamentController {
  public Tournament[] sortSelectionDesc(Tournament[] tournaments) {
    int n = tournaments.length;
    for (int i = 0; i < n - 1; i++) {
      int max = i;
      for (int j = i + 1; j < n; j++) {
        if (tournaments[j].getTotalStarterPoints() > tournaments[max].getTotalStarterPoints()) {
          max = j;
        }
      }

      Tournament cam = tournaments[i];
      tournaments[i] = tournaments[max];
      tournaments[max] = cam;
    }
    return tournaments;
  }

  public Tournament binarySearchByTotalStarterPointsFilaB(Tournament[] tournaments, int totalStarterPoints) {
    int bajo = 0;
    int alto = tournaments.length - 1;

    while (bajo <= alto) {
      int mid = bajo + (alto - bajo) / 2;
      int midVal = tournaments[mid].getTotalStarterPoints();

      if (midVal == totalStarterPoints) {
        return tournaments[mid];
      }

      if (midVal < totalStarterPoints) {
        alto = mid - 1;
      } else {
        bajo = mid + 1;
      }
    }
    return null;
  }
}
