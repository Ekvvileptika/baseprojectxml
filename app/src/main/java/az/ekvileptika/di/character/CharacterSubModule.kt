package az.ekvileptika.di.character

import az.ekvileptika.data.characters.CharactersRepositoryImpl
import az.ekvileptika.domain.CharactersRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class CharacterSubModule {

    @Singleton
    @Binds
    abstract fun provideCharacterRepository(repo: CharactersRepositoryImpl): CharactersRepository
}