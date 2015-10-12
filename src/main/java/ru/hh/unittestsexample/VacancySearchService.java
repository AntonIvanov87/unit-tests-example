package ru.hh.unittestsexample;

import java.util.Collection;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

final class VacancySearchService {

  private final VacancySearchClient vacancySearchClient;

  VacancySearchService(final VacancySearchClient vacancySearchClient) {
    this.vacancySearchClient = vacancySearchClient;
  }

  Map<String, Collection<Integer>> searchVacanciesIdsByTerms(final Collection<String> terms) {
    return terms.stream()
        .collect(
            toMap(
                term -> term,
                vacancySearchClient::searchVacanciesIdsByTerm
            )
        );
  }
}
