package com.velaphi.pokemons.network.model;

/**
 * Pokemon type information.
 */
@com.squareup.moshi.JsonClass(generateAdapter = true)
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/velaphi/pokemons/network/model/Type;", "", "slot", "", "type", "Lcom/velaphi/pokemons/network/model/TypeInfo;", "(ILcom/velaphi/pokemons/network/model/TypeInfo;)V", "getSlot", "()I", "getType", "()Lcom/velaphi/pokemons/network/model/TypeInfo;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "network_debug"})
public final class Type {
    private final int slot = 0;
    @org.jetbrains.annotations.NotNull()
    private final com.velaphi.pokemons.network.model.TypeInfo type = null;
    
    public Type(@com.squareup.moshi.Json(name = "slot")
    int slot, @com.squareup.moshi.Json(name = "type")
    @org.jetbrains.annotations.NotNull()
    com.velaphi.pokemons.network.model.TypeInfo type) {
        super();
    }
    
    public final int getSlot() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.velaphi.pokemons.network.model.TypeInfo getType() {
        return null;
    }
    
    public final int component1() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.velaphi.pokemons.network.model.TypeInfo component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.velaphi.pokemons.network.model.Type copy(@com.squareup.moshi.Json(name = "slot")
    int slot, @com.squareup.moshi.Json(name = "type")
    @org.jetbrains.annotations.NotNull()
    com.velaphi.pokemons.network.model.TypeInfo type) {
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