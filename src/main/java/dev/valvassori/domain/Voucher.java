package dev.valvassori.domain;

public class Voucher {
    private final int id;
    private final String code;
    private final Voucher.Type type;
    private final double amount;

    public Voucher(int id, String code, Type type, double amount) {
        this.id = id;
        this.code = code;
        this.type = type;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("- [Voucher] `#%s` with discount of `%s` (#%d)", code, type.format(amount), id);
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public Type getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public double calculateDiscountFor(double value) {
        switch(type) {
            case VALUE:
                return amount;
            case PERCENTAGE:
                return value * amount;
            default:
                return 0;
        }
    }

    public enum Type {
        VALUE, PERCENTAGE;

        public String format(double value) {
            switch (this) {
                case VALUE:
                    return String.format("$ %.2f", value);
                case PERCENTAGE:
                    return String.format("%.2f %%", value * 100);
                default:
                    return "No discount";
            }
        }
    }
}
