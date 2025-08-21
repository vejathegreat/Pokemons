package com.velaphi.pokemons.network.model;

/**
 * Pokemon ability information.
 */
@com.squareup.moshi.JsonClass(generateAdapter = true)
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0007H\u00c6\u0003J\'\u0010\u0011\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0017"}, d2 = {"Lcom/velaphi/pokemons/network/model/Ability;", "", "ability", "Lcom/velaphi/pokemons/network/model/AbilityInfo;", "isHidden", "", "slot", "", "(Lcom/velaphi/pokemons/network/model/AbilityInfo;ZI)V", "getAbility", "()Lcom/velaphi/pokemons/network/model/AbilityInfo;", "()Z", "getSlot", "()I", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "network_debug"})
public final class Ability {
    @org.jetbrains.annotations.NotNull()
    private final com.velaphi.pokemons.network.model.AbilityInfo ability = null;
    private final boolean isHidden = false;
    private final int slot = 0;
    
    public Ability(@com.squareup.moshi.Json(name = "ability")
    @org.jetbrains.annotations.NotNull()
    com.velaphi.pokemons.network.model.AbilityInfo ability, @com.squareup.moshi.Json(name = "is_hidden")
    boolean isHidden, @com.squareup.moshi.Json(name = "slot")
    int slot) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.velaphi.pokemons.network.model.AbilityInfo getAbility() {
        return null;
    }
    
    public final boolean isHidden() {
        return false;
    }
    
    public final int getSlot() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.velaphi.pokemons.network.model.AbilityInfo component1() {
        return null;
    }
    
    public final boolean component2() {
        return false;
    }
    
    public final int component3() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.velaphi.pokemons.network.model.Ability copy(@com.squareup.moshi.Json(name = "ability")
    @org.jetbrains.annotations.NotNull()
    com.velaphi.pokemons.network.model.AbilityInfo ability, @com.squareup.moshi.Json(name = "is_hidden")
    boolean isHidden, @com.squareup.moshi.Json(name = "slot")
    int slot) {
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