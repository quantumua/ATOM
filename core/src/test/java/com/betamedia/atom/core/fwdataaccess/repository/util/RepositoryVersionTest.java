package com.betamedia.atom.core.fwdataaccess.repository.util;

import org.testng.annotations.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author mbelyaev
 * @since 6/1/17
 */
public class RepositoryVersionTest {
    @Test
    public void testCompareTo() throws Exception {
        RepositoryVersion v100d1 = getRepoVersion("1.0.0", getDate(1));
        RepositoryVersion v100d2 = getRepoVersion("1.0.0", getDate(2));
        RepositoryVersion v101d1 = getRepoVersion("1.0.1", getDate(1));
        RepositoryVersion v110d1 = getRepoVersion("1.1.0", getDate(1));
        RepositoryVersion v200d1 = getRepoVersion("2.0.0", getDate(1));
        assertThat(v100d1.compareTo(v100d2), is(-1));
        assertThat(v100d2.compareTo(v101d1), is(-1));
        assertThat(v101d1.compareTo(v110d1), is(-1));
        assertThat(v110d1.compareTo(v200d1), is(-1));
    }


    private ZonedDateTime getDate(int day) {
        return ZonedDateTime.of(2017, 6, day, 0, 0, 0, 0, ZoneId.of("+0"));
    }

    private RepositoryVersion getRepoVersion(String implVersion, ZonedDateTime implDate) {
        return new RepositoryVersion(implVersion, implDate);
    }

}