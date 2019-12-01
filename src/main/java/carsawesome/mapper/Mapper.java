package carsawesome.mapper;

public interface Mapper<F,T> {

    T map(F f);

    F reverse(T to);

}
