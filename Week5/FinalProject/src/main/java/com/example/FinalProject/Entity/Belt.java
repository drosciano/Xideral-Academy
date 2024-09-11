package com.example.FinalProject.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="belt")
public class Belt {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private Date is10Kup;
    @Column
    private Date is9Kup;
    @Column
    private Date is8Kup;
    @Column
    private Date is7Kup;
    @Column
    private Date is6Kup;
    @Column
    private Date is5Kup;
    @Column
    private Date is4Kup;
    @Column
    private Date is3Kup;
    @Column
    private Date is2Kup;
    @Column
    private Date is1Kup;
    @Column
    private Date isIeby;
    @Column
    private Date is1Dan;
    @Column
    private Date is2Dan;
    @Column
    private Date is3Dan;
    @Column
    private Date is4Dan;
    @Column
    private Date is5Dan;
    @Column
    private Date is6Dan;
    @Column
    private Date is7Dan;
    @Column
    private Date is8Dan;

    public Belt(Builder builder) {
        this.is10Kup = builder.is10Kup;
        this.is9Kup = builder.is9Kup;
        this.is8Kup = builder.is8Kup;
        this.is7Kup = builder.is7Kup;
        this.is6Kup = builder.is6Kup;
        this.is5Kup = builder.is5Kup;
        this.is4Kup = builder.is4Kup;
        this.is3Kup = builder.is3Kup;
        this.is2Kup = builder.is2Kup;
        this.is1Kup = builder.is1Kup;
        this.isIeby = builder.isIeby;
        this.is1Dan = builder.is1Dan;
        this.is2Dan = builder.is2Dan;
        this.is3Dan = builder.is3Dan;
        this.is4Dan = builder.is4Dan;
        this.is5Dan = builder.is5Dan;
        this.is6Dan = builder.is6Dan;
        this.is7Dan = builder.is7Dan;
        this.is8Dan = builder.is8Dan;
    }

    public static class Builder {
        private Date is10Kup;
        private Date is9Kup;
        private Date is8Kup;
        private Date is7Kup;
        private Date is6Kup;
        private Date is5Kup;
        private Date is4Kup;
        private Date is3Kup;
        private Date is2Kup;
        private Date is1Kup;
        private Date isIeby;
        private Date is1Dan;
        private Date is2Dan;
        private Date is3Dan;
        private Date is4Dan;
        private Date is5Dan;
        private Date is6Dan;
        private Date is7Dan;
        private Date is8Dan;

        Builder is10Kup(Date date) {
            this.is10Kup = date;
            return this;
        }

        boolean is10Kup() {
            return is10Kup != null;
        }

        Builder is9Kup(Date date) throws Exception {
            if (is10Kup()) {
                this.is9Kup = date;
            }
            else {
                throw new Exception("You are missing 10 Kup exam");
            }
            return this;
        }

        boolean is9Kup() {
            if (is9Kup != null) {
                return true;
            }
            else {
                return is10Kup();
            }
        }

        Builder is8Kup(Date date) throws Exception {
            if (is9Kup()) {
                this.is8Kup = date;
            }
            else {
                throw new Exception("You are missing 9 Kup exam");
            }
            return this;
        }

        boolean is8Kup() {
            if (is8Kup != null) {
                return true;
            }
            else {
                return is9Kup();
            }
        }

        Builder is7Kup(Date date) throws Exception {
            if (is8Kup()) {
                this.is7Kup = date;
            }
            else {
                throw new Exception("You are missing 8 Kup exam");

            }
            return this;
        }

        boolean is7Kup() {
            if (is7Kup != null) {
                return true;
            }
            else {
                return is8Kup();
            }
        }

        Builder is6Kup(Date date) throws Exception {
            if (is7Kup()) {
                this.is6Kup = date;
            }
            else {
                throw new Exception("You are missing 7 Kup exam");

            }
            return this;
        }

        boolean is6Kup() {
            if (is6Kup != null) {
                return true;
            }
            else {
                return is7Kup();
            }
        }

        Builder is5Kup(Date date) throws Exception {
            if (is6Kup()) {
                this.is5Kup = date;
            }
            else {
                throw new Exception("You are missing 6 Kup exam");

            }
            return this;
        }

        boolean is5Kup() {
            if (is5Kup != null) {
                return true;
            }
            else {
                return is6Kup();
            }
        }

        Builder is4Kup(Date date) throws Exception {
            if (is5Kup()) {
                this.is4Kup = date;
            }
            else {
                throw new Exception("You are missing 5 Kup exam");

            }
            return this;
        }

        boolean is4Kup() {
            if (is4Kup != null) {
                return true;
            }
            else {
                return is5Kup();
            }
        }

        Builder is3Kup(Date date) throws Exception {
            if (is4Kup()) {
                this.is3Kup = date;
            }
            else {
                throw new Exception("You are missing 4 Kup exam");

            }
            return this;
        }

        boolean is3Kup() {
            if (is3Kup != null) {
                return true;
            }
            else {
                return is4Kup();
            }
        }

        Builder is2Kup(Date date) throws Exception {
            if (is3Kup()) {
                this.is2Kup = date;
            }
            else {
                throw new Exception("You are missing 3 Kup exam");

            }
            return this;
        }

        boolean is2Kup() {
            if (is2Kup != null) {
                return true;
            }
            else {
                return is3Kup();
            }
        }

        Builder is1Kup(Date date) throws Exception {
            if (is2Kup()) {
                this.is1Kup = date;
            }
            else {
                throw new Exception("You are missing 2 Kup exam");

            }
            return this;
        }

        boolean is1Kup() {
            if (is1Kup != null) {
                return true;
            }
            else {
                return is2Kup();
            }
        }

        Builder isIeby(Date date) throws Exception {
            if (is1Kup()) {
                this.isIeby = date;
            }
            else {
                throw new Exception("You are missing 1 Kup exam");

            }
            return this;
        }

        boolean isIeby() {
            if (isIeby != null) {
                return true;
            }
            else {
                return is1Kup();
            }
        }

        Builder is1Dan(Date date) throws Exception {
            if (isIeby()) {
                this.is1Dan = date;
            }
            else {
                throw new Exception("You are missing Ieby exam");

            }
            return this;
        }

        boolean is1Dan() {
            if (is1Dan != null) {
                return true;
            }
            else {
                return isIeby();
            }
        }

        Builder is2Dan(Date date) throws Exception {
            if (is1Dan()) {
                this.is2Dan = date;
            }
            else {
                throw new Exception("You are missing 1 Dan exam");

            }
            return this;
        }

        boolean is2Dan() {
            if (is2Dan != null) {
                return true;
            }
            else {
                return is1Dan();
            }
        }

        Builder is3Dan(Date date) throws Exception {
            if (is2Dan()) {
                this.is3Dan = date;
            }
            else {
                throw new Exception("You are missing 2 Dan exam");

            }
            return this;
        }

        boolean is3Dan() {
            if (is3Dan != null) {
                return true;
            }
            else {
                return is2Dan();
            }
        }

        Builder is4Dan(Date date) throws Exception {
            if (is3Dan()) {
                this.is4Dan = date;
            }
            else {
                throw new Exception("You are missing 3 Dan exam");

            }
            return this;
        }

        boolean is4Dan() {
            if (is4Dan != null) {
                return true;
            }
            else {
                return is3Dan();
            }
        }

        Builder is5Dan(Date date) throws Exception {
            if (is4Dan()) {
                this.is5Dan = date;
            }
            else {
                throw new Exception("You are missing 4 Dan exam");

            }
            return this;
        }

        boolean is5Dan() {
            if (is5Dan != null) {
                return true;
            }
            else {
                return is4Dan();
            }
        }

        Builder is6Dan(Date date) throws Exception {
            if (is5Dan()) {
                this.is6Dan = date;
            }
            else {
                throw new Exception("You are missing 5 Dan exam");

            }
            return this;
        }

        boolean is6Dan() {
            if (is6Dan != null) {
                return true;
            }
            else {
                return is5Dan();
            }
        }

        Builder is7Dan(Date date) throws Exception {
            if (is6Dan()) {
                this.is7Dan = date;
            }
            else {
                throw new Exception("You are missing 6 Dan exam");

            }
            return this;
        }

        boolean is7Dan() {
            if (is7Dan != null) {
                return true;
            }
            else {
                return is6Dan();
            }
        }

        Builder is8Dan(Date date) throws Exception {
            if (is7Dan()) {
                this.is8Dan = date;
            }
            else {
                throw new Exception("You are missing 7 Dan exam");

            }
            return this;
        }

        Belt build() {
            return new Belt(this);
        }

    }


}
