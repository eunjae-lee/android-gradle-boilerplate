package net.eunjae.android.boilerplate.type;

public enum BuildType {
    DEBUG,
    RELEASE;

    public boolean isRelease() {
        return this == RELEASE;
    }
}
