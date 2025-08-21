package com.velaphi.pokemons.network.model;

/**
 * Pokemon sprites (images).
 */
@com.squareup.moshi.JsonClass(generateAdapter = true)
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bH\u00c6\u0003JE\u0010\u0016\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\bH\u00c6\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001J\t\u0010\u001b\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001c"}, d2 = {"Lcom/velaphi/pokemons/network/model/Sprites;", "", "frontDefault", "", "frontShiny", "backDefault", "backShiny", "other", "Lcom/velaphi/pokemons/network/model/OtherSprites;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/velaphi/pokemons/network/model/OtherSprites;)V", "getBackDefault", "()Ljava/lang/String;", "getBackShiny", "getFrontDefault", "getFrontShiny", "getOther", "()Lcom/velaphi/pokemons/network/model/OtherSprites;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "hashCode", "", "toString", "network_debug"})
public final class Sprites {
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String frontDefault = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String frontShiny = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String backDefault = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String backShiny = null;
    @org.jetbrains.annotations.Nullable()
    private final com.velaphi.pokemons.network.model.OtherSprites other = null;
    
    public Sprites(@com.squareup.moshi.Json(name = "front_default")
    @org.jetbrains.annotations.Nullable()
    java.lang.String frontDefault, @com.squareup.moshi.Json(name = "front_shiny")
    @org.jetbrains.annotations.Nullable()
    java.lang.String frontShiny, @com.squareup.moshi.Json(name = "back_default")
    @org.jetbrains.annotations.Nullable()
    java.lang.String backDefault, @com.squareup.moshi.Json(name = "back_shiny")
    @org.jetbrains.annotations.Nullable()
    java.lang.String backShiny, @com.squareup.moshi.Json(name = "other")
    @org.jetbrains.annotations.Nullable()
    com.velaphi.pokemons.network.model.OtherSprites other) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getFrontDefault() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getFrontShiny() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getBackDefault() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getBackShiny() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.velaphi.pokemons.network.model.OtherSprites getOther() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.velaphi.pokemons.network.model.OtherSprites component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.velaphi.pokemons.network.model.Sprites copy(@com.squareup.moshi.Json(name = "front_default")
    @org.jetbrains.annotations.Nullable()
    java.lang.String frontDefault, @com.squareup.moshi.Json(name = "front_shiny")
    @org.jetbrains.annotations.Nullable()
    java.lang.String frontShiny, @com.squareup.moshi.Json(name = "back_default")
    @org.jetbrains.annotations.Nullable()
    java.lang.String backDefault, @com.squareup.moshi.Json(name = "back_shiny")
    @org.jetbrains.annotations.Nullable()
    java.lang.String backShiny, @com.squareup.moshi.Json(name = "other")
    @org.jetbrains.annotations.Nullable()
    com.velaphi.pokemons.network.model.OtherSprites other) {
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