package com.epam;

/**
 * @author Evgeny Borisov
 */
@Singleton
public class RecommendatorImpl implements Recommendator {
    @InjectProperty("wisky")
    private String alcohol;

    public RecommendatorImpl() {
        System.out.println("recommendator was created");
    }

    @Override
    @Deprecated
    public void recommend() {
        System.out.println("to protect from covid-2019, drink "+alcohol);
    }
}
