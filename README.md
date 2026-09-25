# Visitor Pattern Demo in Java

For design pattern details, see [Visitor Pattern Documentation](/visitor-pattern.md).

## Running

Requires Java 21.

```sh
./gradlew run    # run the demo
./gradlew test   # run the tests
```

## Structure

- `model/Element` – common `accept(Visitor)` contract implemented by `Car`, `Body`, `Engine`, `Wheel`
- `Visitor<R>` – one `visit` overload per element type
- `PriceVisitor` – example operation added without touching the model
- `Car.accept(visitor, collector)` – visits every part, then the car, and combines results with a `Collector`


## 📄 License

This project is licensed under the [MIT License](LICENSE).

Happy coding! 💻🎉