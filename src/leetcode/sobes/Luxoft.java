//import java.math.BigDecimal;
//import java.util.*;
//import java.io.*;
//import java.util.*;
//import java.text.*;
//import java.math.*;
//import java.util.regex.*;
//import java.util.stream.Collectors;
//public class asd {
//
//
//    class DividendsResolver {
//        /**
//         * The method to implement: group dividend events by stock, and resolve conflicts according to a vendor preference list.
//         *
//         */
//        Map<Stock, ResolvedDividends> getResolvedDividends(
//                Map<Vendor, Collection<Dividend>> dividends,
//                List<Vendor> vendorPreferences
//        ) {
//            Map<Stock, ResolvedDividends> result = new HashMap<>();
//            for (Vendor vendor : dividends.keySet()) {
//                Collection<Dividend> divs = dividends.get(vendor);
//                for (Dividend div: divs) {
//                    Stock stock = div.stock;
//                    Set.of(vendor).stream().allMatch(el -> vendorPreferences.indexOf(vendor) < el);
//                    ResolvedDividends resolvedDividends = new ResolvedDividends(
//                            stock,
//                            new ArrayList<>(divs),
//                            Set.of(vendor)
//                    );
//                    Collections.singleton()
//
////                    result.put(stock, )
//                }
//            }
//            return result;
//        }
//    }
//
//    /** A simplified representation of a vendor. */
//    enum Vendor {
//        A,
//        B,
//        C
//    }
//
//    /** A simplified representation of a stock instrument. */
//    class Stock {
//        public final int id;
//        public final String ticker;
//
//        public Stock(int id, String ticker) {
//            this.id = id;
//            this.ticker = ticker;
//        }
//
//        @Override
//        public String toString() {
//            return ticker;
//        }
//    }
//
//    /** A simplified representation of currency. */
//    enum Currency {
//        USD,
//        EUR
//    }
//
//    /** Base class representing a simplified dividend event (e.g. w/o ex-date). */
//    abstract class Dividend {
//        public final Stock stock;
//
//        public Dividend(Stock stock) {
//            this.stock = stock;
//        }
//    }
//
//    /** A dividend event paid in cash. */
//    class CashDividend extends Dividend {
//        public final BigDecimal netAmount;
//        public final Currency currency;
//
//        public CashDividend(Stock stock, BigDecimal netAmount, Currency currency) {
//            super(stock);
//            this.netAmount = netAmount;
//            this.currency = currency;
//        }
//
//        @Override
//        public String toString() {
//            return "CDIV|" + stock + "|" + netAmount + "|" + currency;
//        }
//    }
//
//    /** A dividend event paid in stock. */
//    class StockDividend extends Dividend {
//        public final BigDecimal shareRatio;
//
//        public StockDividend(Stock stock, BigDecimal shareRatio) {
//            super(stock);
//            this.shareRatio = shareRatio;
//        }
//
//        @Override
//        public String toString() {
//            return "SDIV|" + stock + "|" + shareRatio;
//        }
//    }
//
//    /** The resolved dividends for a stock. */
//    class ResolvedDividends {
//        public final Stock stock;
//        public final List<Dividend> dividends;
//        public final Set<Vendor> vendors;
//
//        public ResolvedDividends(Stock stock, List<Dividend> dividends, Set<Vendor> vendors) {
//            this.stock = stock;
//            this.dividends = dividends;
//            this.vendors = vendors;
//        }
//
//        @Override
//        public String toString() {
//            return stock + ": " + dividends + ", " + vendors;
//        }
//    }
//
//    class Test {
//        final Stock AAPL = new Stock(1, "AAPL");
//        final Stock AMZN = new Stock(2, "AMZN");
//        final Stock IBM = new Stock(3, "IBM");
//
//        void runExampleTest() {
//            Map<Vendor, Collection<Dividend>> input = getExampleInput();
//            List<Vendor> vendorPreferences = Arrays.asList(Vendor.C, Vendor.A, Vendor.B);
//            System.out.println("****** Input ******");
//            printInputs(input, vendorPreferences);
//
//            Map<Stock, ResolvedDividends> expectedOutput = getExampleOutput();
//            System.out.println("\n****** Expected Output ******");
//            printOutput(expectedOutput);
//
//            Map<Stock, ResolvedDividends> actualOutput = DividendsResolver.getResolvedDividends(input, vendorPreferences);
//            System.out.println("\n****** Actual Output ******");
//            printOutput(actualOutput);
//        }
//
//        /** An example input. */
//        Map<Vendor, Collection<Dividend>> getExampleInput() {
//            Map<Vendor, Collection<Dividend>> input = new HashMap<>();
//            input.put(Vendor.A, Arrays.asList(
//                    new CashDividend(AAPL, BigDecimal.valueOf(1), Currency.USD),
//                    new CashDividend(AMZN, BigDecimal.valueOf(0.1), Currency.USD),
//                    new StockDividend(AAPL, BigDecimal.valueOf(0.1)),
//                    new StockDividend(IBM, BigDecimal.valueOf(0.2))));
//            input.put(Vendor.B, Arrays.asList(
//                    new CashDividend(AAPL, BigDecimal.valueOf(2), Currency.USD),
//                    new StockDividend(IBM, BigDecimal.valueOf(0.2))));
//            input.put(Vendor.C, Arrays.asList(
//                    new StockDividend(AMZN, BigDecimal.valueOf(0.3)),
//                    new StockDividend(IBM, BigDecimal.valueOf(0.2))));
//
//            return input;
//        }
//
//        /* An example output. */
//        Map<Stock, ResolvedDividends> getExampleOutput() {
//            Map<Stock, ResolvedDividends> output = new HashMap<>();
//            output.put(
//                    AAPL,
//                    new ResolvedDividends(
//                            AAPL,
//                            Arrays.asList(
//                                    new CashDividend(AAPL, BigDecimal.valueOf(1), Currency.USD),
//                                    new StockDividend(AAPL, BigDecimal.valueOf(0.1))),
//                            EnumSet.of(Vendor.A)));
//            output.put(
//                    AMZN,
//                    new ResolvedDividends(
//                            AMZN,
//                            Arrays.asList(new StockDividend(AMZN, BigDecimal.valueOf(0.3))),
//                            EnumSet.of(Vendor.C)));
//            output.put(
//                    IBM,
//                    new ResolvedDividends(
//                            IBM,
//                            Arrays.asList(new StockDividend(IBM, BigDecimal.valueOf(0.2))),
//                            EnumSet.of(Vendor.A, Vendor.B, Vendor.C)));
//
//            return output;
//        }
//
//        /** Prints the inputs. */
//        static void printInputs(Map<Vendor, Collection<Dividend>> input, List<Vendor> vendorPreferences) {
//            SortedSet<Vendor> sortedVendors = new TreeSet<>(Comparator.comparing(e -> e.toString()));
//            sortedVendors.addAll(input.keySet());
//            for (Vendor vendor: sortedVendors) {
//                System.out.println("(" + vendor + ")");
//                for (Dividend div : input.get(vendor)) {
//                    System.out.println("  " + div);
//                }
//            }
//            System.out.println(vendorPreferences.stream().map(e -> e.toString()).collect(Collectors.joining(" > ")));
//        }
//
//        /** Prints the output. */
//        static void printOutput(Map<Stock, ResolvedDividends> output) {
//            SortedSet<Stock> sortedStocks = new TreeSet<>(Comparator.comparing(e -> e.ticker));
//            sortedStocks.addAll(output.keySet());
//            for (Stock stock: sortedStocks) {
//                System.out.println("(" + stock + ")");
//                System.out.println(output.get(stock));
//            }
//        }
//    }
//
//
//    public class Solution {
//        public static void main(String args[] ) throws Exception {
//            new Test().runExampleTest();
//
//            // dummy output
//            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//            bufferedWriter.newLine();
//            bufferedWriter.close();
//        }
//    }
//}
