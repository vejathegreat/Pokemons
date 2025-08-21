package com.velaphi.pokemons.network.model;

/**
 * Detailed Pokemon information response.
 */
@com.squareup.moshi.JsonClass(generateAdapter = true)
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003\u0012\b\b\u0001\u0010\t\u001a\u00020\n\u0012\u000e\b\u0001\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u000e\b\u0001\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\f\u0012\u000e\b\u0001\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\f\u0012\u000e\b\u0001\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\f\u00a2\u0006\u0002\u0010\u0014J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00130\fH\u00c6\u0003J\t\u0010\'\u001a\u00020\u0005H\u00c6\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0018J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\t\u0010*\u001a\u00020\u0003H\u00c6\u0003J\t\u0010+\u001a\u00020\nH\u00c6\u0003J\u000f\u0010,\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u00c6\u0003J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000f0\fH\u00c6\u0003J\u000f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00110\fH\u00c6\u0003J\u008c\u0001\u0010/\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0007\u001a\u00020\u00032\b\b\u0003\u0010\b\u001a\u00020\u00032\b\b\u0003\u0010\t\u001a\u00020\n2\u000e\b\u0003\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u000e\b\u0003\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\f2\u000e\b\u0003\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\f2\u000e\b\u0003\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\fH\u00c6\u0001\u00a2\u0006\u0002\u00100J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00104\u001a\u00020\u0003H\u00d6\u0001J\t\u00105\u001a\u00020\u0005H\u00d6\u0001R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001c\u00a8\u00066"}, d2 = {"Lcom/velaphi/pokemons/network/model/PokemonDetailResponse;", "", "id", "", "name", "", "baseExperience", "height", "weight", "sprites", "Lcom/velaphi/pokemons/network/model/Sprites;", "stats", "", "Lcom/velaphi/pokemons/network/model/Stat;", "types", "Lcom/velaphi/pokemons/network/model/Type;", "abilities", "Lcom/velaphi/pokemons/network/model/Ability;", "forms", "Lcom/velaphi/pokemons/network/model/Form;", "(ILjava/lang/String;Ljava/lang/Integer;IILcom/velaphi/pokemons/network/model/Sprites;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getAbilities", "()Ljava/util/List;", "getBaseExperience", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getForms", "getHeight", "()I", "getId", "getName", "()Ljava/lang/String;", "getSprites", "()Lcom/velaphi/pokemons/network/model/Sprites;", "getStats", "getTypes", "getWeight", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ILjava/lang/String;Ljava/lang/Integer;IILcom/velaphi/pokemons/network/model/Sprites;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)Lcom/velaphi/pokemons/network/model/PokemonDetailResponse;", "equals", "", "other", "hashCode", "toString", "network_debug"})
public final class PokemonDetailResponse {
    private final int id = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String name = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer baseExperience = null;
    private final int height = 0;
    private final int weight = 0;
    @org.jetbrains.annotations.NotNull()
    private final com.velaphi.pokemons.network.model.Sprites sprites = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.velaphi.pokemons.network.model.Stat> stats = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.velaphi.pokemons.network.model.Type> types = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.velaphi.pokemons.network.model.Ability> abilities = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.velaphi.pokemons.network.model.Form> forms = null;
    
    public PokemonDetailResponse(@com.squareup.moshi.Json(name = "id")
    int id, @com.squareup.moshi.Json(name = "name")
    @org.jetbrains.annotations.NotNull()
    java.lang.String name, @com.squareup.moshi.Json(name = "base_experience")
    @org.jetbrains.annotations.Nullable()
    java.lang.Integer baseExperience, @com.squareup.moshi.Json(name = "height")
    int height, @com.squareup.moshi.Json(name = "weight")
    int weight, @com.squareup.moshi.Json(name = "sprites")
    @org.jetbrains.annotations.NotNull()
    com.velaphi.pokemons.network.model.Sprites sprites, @com.squareup.moshi.Json(name = "stats")
    @org.jetbrains.annotations.NotNull()
    java.util.List<com.velaphi.pokemons.network.model.Stat> stats, @com.squareup.moshi.Json(name = "types")
    @org.jetbrains.annotations.NotNull()
    java.util.List<com.velaphi.pokemons.network.model.Type> types, @com.squareup.moshi.Json(name = "abilities")
    @org.jetbrains.annotations.NotNull()
    java.util.List<com.velaphi.pokemons.network.model.Ability> abilities, @com.squareup.moshi.Json(name = "forms")
    @org.jetbrains.annotations.NotNull()
    java.util.List<com.velaphi.pokemons.network.model.Form> forms) {
        super();
    }
    
    public final int getId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getBaseExperience() {
        return null;
    }
    
    public final int getHeight() {
        return 0;
    }
    
    public final int getWeight() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.velaphi.pokemons.network.model.Sprites getSprites() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.velaphi.pokemons.network.model.Stat> getStats() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.velaphi.pokemons.network.model.Type> getTypes() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.velaphi.pokemons.network.model.Ability> getAbilities() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.velaphi.pokemons.network.model.Form> getForms() {
        return null;
    }
    
    public final int component1() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.velaphi.pokemons.network.model.Form> component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component3() {
        return null;
    }
    
    public final int component4() {
        return 0;
    }
    
    public final int component5() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.velaphi.pokemons.network.model.Sprites component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.velaphi.pokemons.network.model.Stat> component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.velaphi.pokemons.network.model.Type> component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.velaphi.pokemons.network.model.Ability> component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.velaphi.pokemons.network.model.PokemonDetailResponse copy(@com.squareup.moshi.Json(name = "id")
    int id, @com.squareup.moshi.Json(name = "name")
    @org.jetbrains.annotations.NotNull()
    java.lang.String name, @com.squareup.moshi.Json(name = "base_experience")
    @org.jetbrains.annotations.Nullable()
    java.lang.Integer baseExperience, @com.squareup.moshi.Json(name = "height")
    int height, @com.squareup.moshi.Json(name = "weight")
    int weight, @com.squareup.moshi.Json(name = "sprites")
    @org.jetbrains.annotations.NotNull()
    com.velaphi.pokemons.network.model.Sprites sprites, @com.squareup.moshi.Json(name = "stats")
    @org.jetbrains.annotations.NotNull()
    java.util.List<com.velaphi.pokemons.network.model.Stat> stats, @com.squareup.moshi.Json(name = "types")
    @org.jetbrains.annotations.NotNull()
    java.util.List<com.velaphi.pokemons.network.model.Type> types, @com.squareup.moshi.Json(name = "abilities")
    @org.jetbrains.annotations.NotNull()
    java.util.List<com.velaphi.pokemons.network.model.Ability> abilities, @com.squareup.moshi.Json(name = "forms")
    @org.jetbrains.annotations.NotNull()
    java.util.List<com.velaphi.pokemons.network.model.Form> forms) {
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