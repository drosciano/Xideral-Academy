package org.example;

enum Resolution {
    Normal,
    HD,
    FullHD,
}

public class StreamingSubscription {
    String subName;
    double price;

    String name;
    Boolean ads;
    Resolution resolution;
    int devices;

    private StreamingSubscription(Builder builder) {
        this.subName = builder.subName;
        this.price = builder.price;
        this.name = builder.name;
        this.ads = builder.ads;
        this.resolution = builder.resolution;
        this.devices = builder.devices;
    }

    @Override
    public String toString() {
        return "StreamingSubscription{" +
                "subName='" + subName + '\'' +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", ads=" + ads +
                ", resolution=" + resolution +
                ", devices=" + devices +
                '}';
    }

    public static class Builder {
        String subName;
        double price;

        String name;
        Boolean ads;
        Resolution resolution;
        int devices;

        Builder(String subName, double price) {
            this.subName = subName;
            this.price = price;
        }

        Builder ads(Boolean ads) {
            this.ads = ads;
            if (!ads) {
                this.price += 0.50;
            }
            return this;
        }

        Builder devices(int devices) {
            this.devices = devices;
            this.price += 1.5 * (devices - 1);
            return this;
        }

        Builder name(String name) {
            this.name = name;
            return this;
        }

        Builder resolution(Resolution resolution) {
            this.resolution = resolution;
            switch (resolution) {
                case HD:
                    this.price += 0.50;
                    break;
                case FullHD:
                    this.price += 0.75;
                    break;
                default:
                    break;
            }
            return this;
        }

        StreamingSubscription build() {
            return new StreamingSubscription(this);
        }
    }
}
