package ru.hh.unittestsexample;

import java.util.Collection;
import java.util.List;
import java.util.Random;

import static java.lang.String.format;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.generate;

// Primitive production implementation of VacancySearchClient interface
final class VacancySearchClientImpl implements VacancySearchClient {

  private final String host;
  private final int port;

  VacancySearchClientImpl(final String host, final int port) {
    this.host = host;
    this.port = port;
  }

  @Override
  public Collection<Integer> searchVacanciesIdsByTerm(final String term) {
    System.out.println(format("asking %s:%d to return vacancies ids by term '%s'...", host, port, term));

    // to keep things simple, do not ask host:port, but generate vacancies ids randomly
    final Random random = new Random();
    final List<Integer> vacanciesIds =
        generate(() -> random.nextInt(100))
            .limit(random.nextInt(10))
            .collect(toList());

    System.out.println(format("%s:%d returned %s", host, port, vacanciesIds));
    return vacanciesIds;
  }
}
