import java.util.Scanner;
class Weather {
    String condition;
    double temperature;

    public Weather(String condition, double temperature) {
        this.condition = condition;
        this.temperature = temperature;
    }

    public void displayWeather() {
        System.out.println("Condition: " + condition);
        System.out.println("Temperature: " + temperature + "°C");
    }

    public void analyzeWeather() {
        if (temperature > 30) {
            System.out.println("It's a hot day!");
        } else if (temperature < 0) {
            System.out.println("It's freezing!");
        } else {
            System.out.println("The weather is moderate.");
        }
    }
}
class SunnyWeather extends Weather {

    public SunnyWeather(double temperature) {
        super("Sunny", temperature);
    }
    public void analyzeWeather() {
        super.analyzeWeather();
        System.out.println("Don't forget your sunglasses!");
    }
}
class RainyWeather extends Weather {

    public RainyWeather(double temperature) {
        super("Rainy", temperature);
    }
    public void analyzeWeather() {
        super.analyzeWeather();
        System.out.println("Carry an umbrella today.");
    }
}
class SnowyWeather extends Weather {

    public SnowyWeather(double temperature) {
        super("Snowy", temperature);
    }
    public void analyzeWeather() {
        super.analyzeWeather();
        System.out.println("Wear warm clothes and be careful on icy roads.");
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter weather condition (Sunny, Rainy, Snowy): ");
        String condition = scanner.nextLine();

        System.out.print("Enter temperature in Celsius: ");
        double temperature = scanner.nextDouble();

        Weather weather;

        switch (condition.toLowerCase()) {
            case "sunny":
                weather = new SunnyWeather(temperature);
                break;
            case "rainy":
                weather = new RainyWeather(temperature);
                break;
            case "snowy":
                weather = new SnowyWeather(temperature);
                break;
            default:
                System.out.println("Unknown weather condition. Using general weather analysis.");
                weather = new Weather("General", temperature);
        }

        weather.displayWeather();
        weather.analyzeWeather();

        scanner.close();
    }
}
