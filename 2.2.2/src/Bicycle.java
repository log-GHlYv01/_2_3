public class Bicycle extends MultiWheeledTransport implements Serviceble{
    public Bicycle(String modelName, int wheelsCount) {
        super(modelName, wheelsCount);
    }

    private void updateTyre() {
            System.out.println("Меняем покрышку");
        }

    @Override
    public void check() {
        System.out.println("Обслуживаем " + getModelName());
        for (int i = 0; i < getWheelsCount(); i++) {
            updateTyre();
        }
    }
}

