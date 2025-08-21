package com.velaphi.pokemons.core;

/**
 * Base interface for all use cases in the application.
 * This follows the Use Case pattern from Clean Architecture.
 *
 * @param P The type of parameters the use case requires
 * @param R The type of result the use case returns
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003J\"\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00060\u00052\u0006\u0010\u0007\u001a\u00028\u0000H\u00a6@\u00a2\u0006\u0002\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/velaphi/pokemons/core/BaseUseCase;", "P", "R", "", "execute", "Lkotlinx/coroutines/flow/Flow;", "Lcom/velaphi/pokemons/core/Result;", "params", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_debug"})
public abstract interface BaseUseCase<P extends java.lang.Object, R extends java.lang.Object> {
    
    /**
     * Execute the use case with the given parameters.
     * @param params The parameters required for the use case
     * @return Flow of Result containing the result or error
     */
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object execute(P params, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.velaphi.pokemons.core.Result<? extends R>>> $completion);
}