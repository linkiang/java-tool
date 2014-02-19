/*
 * Copyright (C) 2013 The Java Tool project
 * Gelin Luo <greenlaw110(at)gmail.com>
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/
package org.osgl.util;

import org.osgl._;
import org.osgl.exception.NotAppliedException;

import java.io.Serializable;
import java.util.*;

/**
 * Implementing immutable empty collection types
 */
abstract class Nil<T> extends SequenceBase<T> implements C.Traversable<T>, Collection<T>, Serializable {

    private static final long serialVersionUID = -5058901899659394002L;

    public static final EmptySequence SEQUENCE = EmptySequence.INSTANCE;

    @SuppressWarnings("unchecked")
    public static <T> EmptySequence<T> seq() {
        return (EmptySequence<T>) SEQUENCE;
    }

    public static final EmptyReversibleSequence REVERSIBLE_SEQUENCE = EmptyReversibleSequence.INSTANCE;

    @SuppressWarnings("unchecked")
    public static <T> EmptyReversibleSequence<T> rseq() {
        return (EmptyReversibleSequence<T>) REVERSIBLE_SEQUENCE;
    }

    public static final EmptyRange RANGE = EmptyRange.INSTANCE;

    @SuppressWarnings("unchecked")
    public static <T> EmptyRange<T> range() {
        return (EmptyRange<T>) RANGE;
    }

    public static final EmptyList LIST = EmptyList.INSTANCE;

    @SuppressWarnings("unchecked")
    public static <T> EmptyList<T> list() {
        return (EmptyList<T>) EmptyList.INSTANCE;
    }

    public static EmptySet SET = EmptySet.INSTANCE;

    @SuppressWarnings("unchecked")
    public static <T> EmptySet<T> set() {
        return (EmptySet<T>) EmptySet.INSTANCE;
    }

    public static final Empty EMPTY = Empty.INSTANCE;

    @SuppressWarnings("unchecked")
    public static <T> Empty<T> empty() {
        return (Empty<T>) Empty.INSTANCE;
    }

//    public static final EmptySet SET = EmptySet.INSTANCE;
//
//    @SuppressWarnings("unchecked")
//    public static <T> EmptySet<T> set() {
//        return (EmptySet<T>) EmptySet.INSTANCE;
//    }
//
//    public static final EmptySortedSet SORTED_SET = EmptySortedSet.INSTANCE;
//
//    @SuppressWarnings("unchecked")
//    public static <T> EmptySortedSet<T> sortedSet() {
//        return (EmptySortedSet<T>) EmptySortedSet.INSTANCE;
//    }
//
    private Nil() {
    }

    @Override
    protected EnumSet<C.Feature> initFeatures() {
        return EnumSet.of(C.Feature.IMMUTABLE, C.Feature.ORDERED, C.Feature.LIMITED, C.Feature.RANDOM_ACCESS, C.Feature.READONLY, C.Feature.SORTED, C.Feature.PARALLEL);
    }

    protected final java.util.List<T> emptyJavaList() {
        return Collections.emptyList();
    }

    protected abstract <T> Nil<T> singleton();

    @Override
    protected final Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public final Iterator<T> iterator() {
        return emptyJavaList().iterator();
    }

    @Override
    public final int size() {
        return 0;
    }

    @Override
    public final boolean contains(Object o) {
        return false;
    }

    @Override
    public final Object[] toArray() {
        return new Object[0];
    }

    @Override
    public final <T1> T1[] toArray(T1[] a) {
        return emptyJavaList().toArray(a);
    }

    @Override
    public final boolean add(T t) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean containsAll(Collection<?> c) {
        return c.isEmpty();
    }

    @Override
    public final boolean addAll(Collection<? extends T> c) {
        if (c.isEmpty()) {
            return false;
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public final boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public final void clear() {
    }

    @Override
    public final boolean isEmpty() {
        return true;
    }

    @Override
    public <R> C.Sequence<R> map(_.Function<? super T, ? extends R> mapper) {
        return singleton();
    }

    @Override
    public <R> C.Sequence<R> flatMap(_.Function<? super T, ? extends Iterable<? extends R>> mapper) {
        return singleton();
    }

    @Override
    public Nil<T> filter(_.Function<? super T, Boolean> predicate) {
        return this;
    }

    @Override
    public final <R> R reduce(R identity, _.Func2<R, T, R> accumulator) {
        return identity;
    }

    @Override
    public final _.Option<T> reduce(_.Func2<T, T, T> accumulator) {
        return _.none();
    }

    @Override
    public final boolean allMatch(_.Function<? super T, Boolean> predicate) {
        return false;
    }

    @Override
    public final boolean anyMatch(_.Function<? super T, Boolean> predicate) {
        return false;
    }

    @Override
    public final boolean noneMatch(_.Function<? super T, Boolean> predicate) {
        return true;
    }

    @Override
    public final _.Option<T> findOne(_.Function<? super T, Boolean> predicate) {
        return _.none();
    }

    @Override
    public Nil<T> accept(_.Function<? super T, ?> visitor) {
        return this;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        return obj == this;
    }

    static class EmptySequence<T> extends Nil<T> implements C.Sequence<T> {

        private static final EmptySequence INSTANCE = new EmptySequence();

        private EmptySequence() {
        }

        protected <T> EmptySequence<T> singleton() {
            return INSTANCE;
        }

        /**
         * {@inheritDoc}
         * <p>Returns an immutable singleton list contains the element
         * specified</p>
         *
         * @param t the element to be appended to this sequence
         * @return a singleton list of the element
         */
        @Override
        public C.Sequence<T> append(T t) {
            return C.list(t);
        }

        /**
         * {@inheritDoc}
         * <p>Returns an immutable singleton list contains the
         * element specified</p>
         *
         * @param t the element to be prepended to this sequence
         * @return a singleton list of the element
         */
        @Override
        public C.Sequence<T> prepend(T t) {
            return C.list(t);
        }

        /**
         * {@inheritDoc}
         * <p>Returns identity specified</p>
         *
         * @param identity    {@inheritDoc}
         * @param accumulator {@inheritDoc}
         * @param <R>         the type of identity and result
         * @return {@inheritDoc}
         */
        @Override
        public <R> R reduceLeft(R identity, _.Func2<R, T, R> accumulator) {
            return identity;
        }

        @Override
        public _.Option<T> reduceLeft(_.Func2<T, T, T> accumulator) {
            return _.none();
        }

        @Override
        public _.Option<T> findFirst(_.Function<? super T, Boolean> predicate) {
            return _.none();
        }

        @Override
        public EmptySequence<T> acceptLeft(_.Function<? super T, ?> visitor) {
            return this;
        }

        @Override
        public EmptySequence<T> accept(_.Function<? super T, ?> visitor) {
            return this;
        }

        @Override
        public T first() {
            throw new NoSuchElementException();
        }

        @Override
        public EmptySequence<T> head(int n) {
            return this;
        }

        @Override
        public EmptySequence<T> tail() throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }

        @Override
        public EmptySequence<T> take(int n) {
            return this;
        }

        @Override
        public EmptySequence<T> takeWhile(_.Function<? super T, Boolean> predicate) {
            return this;
        }

        @Override
        public EmptySequence<T> drop(int n) {
            return this;
        }

        @Override
        public EmptySequence<T> dropWhile(_.Function<? super T, Boolean> predicate) {
            return this;
        }

        @Override
        public <R> EmptySequence<R> map(_.Function<? super T, ? extends R> mapper) {
            return singleton();
        }

        @Override
        public <R> EmptySequence<R> flatMap(_.Function<? super T, ? extends Iterable<? extends R>> mapper) {
            return singleton();
        }

        @Override
        public EmptySequence<T> filter(_.Function<? super T, Boolean> predicate) {
            return this;
        }

        @Override
        public C.Sequence<T> append(C.Sequence<T> seq) {
            return seq;
        }

        @Override
        public C.Sequence<T> prepend(C.Sequence<T> seq) {
            return seq;
        }

        // Preserves singleton property
        private Object readResolve() {
            return INSTANCE;
        }
    }

    static class EmptyReversibleSequence<T>
    extends EmptySequence<T> implements C.ReversibleSequence<T> {

        private static final EmptyReversibleSequence INSTANCE = new EmptyReversibleSequence();

        @Override
        protected <T1> EmptyReversibleSequence<T1> singleton() {
            return INSTANCE;
        }

        @Override
        public C.ReversibleSequence<T> lazy() {
            return (C.ReversibleSequence<T>)super.lazy();
        }

        @Override
        public C.ReversibleSequence<T> eager() {
            return (C.ReversibleSequence<T>)super.eager();
        }

        @Override
        public C.ReversibleSequence<T> parallel() {
            return (C.ReversibleSequence<T>)super.parallel();
        }

        @Override
        public C.ReversibleSequence<T> sequential() {
            return (C.ReversibleSequence<T>)super.sequential();
        }

        @Override
        public T last() throws UnsupportedOperationException, NoSuchElementException {
            throw new NoSuchElementException();
        }

        @Override
        public EmptyReversibleSequence<T> reverse() throws UnsupportedOperationException {
            return this;
        }

        @Override
        public EmptyReversibleSequence<T> take(int n) {
            return this;
        }

        @Override
        public EmptyReversibleSequence<T> head(int n) {
            return this;
        }

        @Override
        public EmptyReversibleSequence<T> tail() throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }

        @Override
        public EmptyReversibleSequence<T> tail(int n) throws UnsupportedOperationException {
            return this;
        }

        @Override
        public EmptyReversibleSequence<T> drop(int n) {
            return this;
        }

        @Override
        public Iterator<T> reverseIterator() {
            return iterator();
        }

        @Override
        public EmptyReversibleSequence<T> accept(_.Function<? super T, ?> visitor) {
            return this;
        }

        @Override
        public EmptyReversibleSequence<T> takeWhile(_.Function<? super T, Boolean> predicate) {
            return this;
        }

        @Override
        public EmptyReversibleSequence<T> dropWhile(_.Function<? super T, Boolean> predicate) {
            return this;
        }

        @Override
        public <R> EmptyReversibleSequence<R> map(_.Function<? super T, ? extends R> mapper) {
            return singleton();
        }

        @Override
        public <R> EmptyReversibleSequence<R> flatMap(_.Function<? super T, ? extends Iterable<? extends R>> mapper) {
            return singleton();
        }

        @Override
        public EmptyReversibleSequence<T> filter(_.Function<? super T, Boolean> predicate) {
            return this;
        }

        @Override
        public EmptyReversibleSequence<T> acceptLeft(_.Function<? super T, ?> visitor) {
            return this;
        }

        @Override
        public <R> R reduceRight(R identity, _.Func2<R, T, R> accumulator) {
            return identity;
        }

        @Override
        public _.Option<T> reduceRight(_.Func2<T, T, T> accumulator) {
            return _.none();
        }

        @Override
        public _.Option<T> findLast(_.Function<? super T, Boolean> predicate) {
            return _.none();
        }

        @Override
        public EmptyReversibleSequence<T> acceptRight(_.Function<? super T, ?> visitor) {
            return this;
        }

        @Override
        public C.ReversibleSequence<T> append(C.ReversibleSequence<T> seq) {
            return seq;
        }

        @Override
        public C.ReversibleSequence<T> append(T t) {
            return C.list(t);
        }

        @Override
        public C.ReversibleSequence<T> prepend(C.ReversibleSequence<T> seq) {
            return seq;
        }

        @Override
        public C.ReversibleSequence<T> prepend(T t) {
            return C.list(t);
        }

        @Override
        public <T2> C.ReversibleSequence<_.T2<T, T2>> zip(C.ReversibleSequence<T2> rseq) {
            return rseq();
        }

        @Override
        public <T2> C.ReversibleSequence<_.T2<T, T2>> zipAll(C.ReversibleSequence<T2> rseq, final T def1, final T2 def2) {
            return rseq.map(new _.F1<T2, _.T2<T, T2>>(){
                @Override
                public _.T2<T, T2> apply(T2 t) throws NotAppliedException, _.Break {
                    return _.T2(def1, t);
                }
            });
        }
    }

    static class EmptyRange<T> extends EmptySequence<T> implements C.Range<T>, RandomAccess {
        private static final EmptyRange INSTANCE = new EmptyRange();

        @Override
        public T from() {
            throw new NoSuchElementException();
        }

        @Override
        public T to() {
            throw new NoSuchElementException();
        }

        @Override
        public T last() {
            throw new NoSuchElementException();
        }

        @Override
        public boolean containsAll(C.Range<T> r2) {
            return false;
        }

        @Override
        @SuppressWarnings("unchecked")
        public Comparator<T> order() {
            return (Comparator<T>)_.F.NATURAL_ORDER;
        }

        @Override
        public _.Func2<T, Integer, T> step() {
            return _.f2();
        }

        @Override
        public C.Range<T> merge(C.Range<T> r2) {
            return r2;
        }

        @Override
        public EmptyRange<T> accept(_.Function<? super T, ?> visitor) {
            return this;
        }

        @Override
        public EmptyRange<T> acceptLeft(_.Function<? super T, ?> visitor) {
            return this;
        }

        @Override
        public C.Range<T> acceptRight(_.Function<? super T, ?> visitor) {
            return this;
        }

        @Override
        public C.Range<T> tail(int n) {
            return this;
        }

        @Override
        public C.Range<T> reverse() {
            return this;
        }

        @Override
        public Iterator<T> reverseIterator() {
            return iterator();
        }

        @Override
        public <R> R reduceRight(R identity, _.Func2<R, T, R> accumulator) {
            return identity;
        }

        @Override
        public _.Option<T> reduceRight(_.Func2<T, T, T> accumulator) {
            return _.none();
        }

        @Override
        public _.Option<T> findLast(_.Function<? super T, Boolean> predicate) {
            return _.none();
        }
    }

    static class EmptyList<T> extends ImmutableList<T> implements C.List<T>, RandomAccess {

        private static final long serialVersionUID = 2142813031316831861L;

        private EmptyList() {
            super((T[])new Object[]{});
        }

        private static final EmptyList<?> INSTANCE = new EmptyList();

        @SuppressWarnings("unchecked")
        protected <T1> EmptyList<T1> singleton() {
            return (EmptyList<T1>) INSTANCE;
        }

        @Override
        public boolean isEmpty() {
            return true;
        }

        // Preserves singleton property
        private Object readResolve() {
            return INSTANCE;
        }
    }

    static class EmptySet<T> extends ImmutableSet<T> implements C.Set<T>, Serializable {

        private static final long serialVersionUID = 4142843931316831861L;

        private EmptySet() {
            super(Collections.EMPTY_SET);
        }

        private static final EmptySet<?> INSTANCE = new EmptySet();

        @SuppressWarnings("unchecked")
        protected EmptySet<T> singleton() {
            return (EmptySet<T>) INSTANCE;
        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public boolean isEmpty() {
            return true;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return c.isEmpty();
        }

        @Override
        public EmptySet<T> accept(_.Function<? super T, ?> visitor) {
            return this;
        }

        // Preserves singleton property
        private Object readResolve() {
            return INSTANCE;
        }
    }

    static class Empty<T> extends EmptyList<T> implements C.ListOrSet<T> {

        private static final Empty INSTANCE = new Empty();

        @Override
        public Empty<T> parallel() {
            return this;
        }

        @Override
        public Empty<T> lazy() {
            return this;
        }

        @Override
        public Empty<T> filter(_.Function<? super T, Boolean> predicate) {
            return this;
        }

        @Override
        public Empty<T> eager() {
            return this;
        }

        @Override
        public Empty<T> sequential() {
            return this;
        }

        @Override
        public Empty<T> accept(_.Function<? super T, ?> visitor) {
            return this;
        }

    }
//
//    static class EmptySortedSet<T> extends EmptyReversibleSequence<T> implements C.SortedSet<T>, Serializable {
//
//        private static final long serialVersionUID = 8142843931221131271L;
//
//        private EmptySortedSet() {
//        }
//
//        private static final EmptySortedSet<?> INSTANCE = new EmptySortedSet();
//
//        @Override
//        @SuppressWarnings("unchecked")
//        protected EmptySortedSet<T> singleton() {
//            return (EmptySortedSet<T>) INSTANCE;
//        }
//
//        @Override
//        public EmptySortedSet<T> accept(_.Function<? super T, ?> visitor) {
//            return this;
//        }
//
//        @Override
//        public Comparator<? super T> comparator() {
//            throw new UnsupportedOperationException();
//        }
//
//        @Override
//        public SortedSet<T> subSet(T fromElement, T toElement) {
//            return this;
//        }
//
//        @Override
//        public SortedSet<T> headSet(T toElement) {
//            return this;
//        }
//
//        @Override
//        public SortedSet<T> tailSet(T fromElement) {
//            return this;
//        }
//
//        // Preserves singleton property
//        private Object readResolve() {
//            return INSTANCE;
//        }
//    }

}