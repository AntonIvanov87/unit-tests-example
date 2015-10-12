package ru.hh.unittestsexample;

import java.util.Collection;

import static java.util.stream.Collectors.toList;

final class VacancySearchController {

  private final VacancySearchService vacancySearchService;

  VacancySearchController(final VacancySearchService vacancySearchService) {
    this.vacancySearchService = vacancySearchService;
  }

  String searchVacanciesIdsByTerms(final Collection<String> terms) {
    // to keep things simple, just return some string representation of terms and vacancies ids
    // real application can return json, draw some window... whatever
    return vacancySearchService.searchVacanciesIdsByTerms(terms)
        .entrySet().stream()
        .map(termAndVacanciesIds -> termAndVacanciesIds.getKey() + ": " + termAndVacanciesIds.getValue())
        .collect(toList())
        .toString();
  }
}
