package com.velaphi.pokemons.network.model;

/**
 * Response model for the Pokemon list endpoint.
 */
@com.squareup.moshi.JsonClass(generateAdapter = true)
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0001\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u00c6\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u000e\b\u0003\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u00c6\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001b\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001c"}, d2 = {"Lcom/velaphi/pokemons/network/model/PokemonListResponse;", "", "count", "", "next", "", "previous", "results", "", "Lcom/velaphi/pokemons/network/model/PokemonListItem;", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getCount", "()I", "getNext", "()Ljava/lang/String;", "getPrevious", "getResults", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "network_debug"})
public final class PokemonListResponse {
    private final int count = 0;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String next = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String previous = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.velaphi.pokemons.network.model.PokemonListItem> results = null;
    
    public PokemonListResponse(@com.squareup.moshi.Json(name = "count")
    int count, @com.squareup.moshi.Json(name = "next")
    @org.jetbrains.annotations.Nullable()
    java.lang.String next, @com.squareup.moshi.Json(name = "previous")
    @org.jetbrains.annotations.Nullable()
    java.lang.String previous, @com.squareup.moshi.Json(name = "results")
    @org.jetbrains.annotations.NotNull()
    java.util.List<com.velaphi.pokemons.network.model.PokemonListItem> results) {
        super();
    }
    
    public final int getCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getNext() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPrevious() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.velaphi.pokemons.network.model.PokemonListItem> getResults() {
        return null;
    }
    
    public final int component1() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.velaphi.pokemons.network.model.PokemonListItem> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.velaphi.pokemons.network.model.PokemonListResponse copy(@com.squareup.moshi.Json(name = "count")
    int count, @com.squareup.moshi.Json(name = "next")
    @org.jetbrains.annotations.Nullable()
    java.lang.String next, @com.squareup.moshi.Json(name = "previous")
    @org.jetbrains.annotations.Nullable()
    java.lang.String previous, @com.squareup.moshi.Json(name = "results")
    @org.jetbrains.annotations.NotNull()
    java.util.List<com.velaphi.pokemons.network.model.PokemonListItem> results) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}